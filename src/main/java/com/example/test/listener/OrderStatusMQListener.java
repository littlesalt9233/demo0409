package com.example.test.listener;


import com.example.test.enums.OrderBizTypeEnum;
import com.example.test.enums.OrderStatusEnum;
import com.example.test.evnts.CompletelyOrderEvent;
import com.example.test.evnts.PayOrderEvent;
import com.example.test.logAop.TraceLog;
import com.example.test.model.OrderInfo;
import com.example.test.service.OrderService;
import com.example.test.strategy.OrderProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

/**
 * @Author chenjw
 * @Email chixe9233@163.com
 * @Date 2024/4/9 14:56
 * @Version 1.0
 * @Desc mq事件监听伪代码
 */
public class OrderStatusMQListener {

//    private OrderService orderService = new OrderService();
//    private PayService payService = new PayService();
//    private NotifyService notifyService;


    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderProcessor orderProcessor;

    @Autowired
    private ApplicationEventPublisher eventPublisher;
    /**
     * 消费订单队列信息
     * @param orderNo 订单号
     * */
    @TraceLog(traceName = "OrderStatusMQListener",threadLog = "OrderStatusMQListener 消费了消息")
    public void consume(String orderNo) {
        final OrderInfo orderInfo = orderService.getOrderInfo(orderNo);
        // 订单业务类型
        final String orderBizType = orderInfo.getOrderBizType();
        // 订单状态
        final int status = orderInfo.getStatus();

        OrderStatusEnum statusEnum = OrderStatusEnum.getByValue(status);
        OrderBizTypeEnum bizType = OrderBizTypeEnum.getByValue(orderBizType);

        orderProcessor.processOrder(bizType,statusEnum);
        switch (statusEnum){
            case s1:
                //发布事件  创建，待支付执行支付
                eventPublisher.publishEvent(new PayOrderEvent(bizType,statusEnum,this));
                break;
            case s2:
                //发布事件 订单完成
                eventPublisher.publishEvent(new CompletelyOrderEvent(bizType,statusEnum,this));
                break;
            default: //其他事件
                break;
        }
        /**
        if (1 == status) { // 创建，待支付执行支付
            // 酒店订单
            if ("hotel".equals(orderBizType)) {
                // 酒店订单支付前的检查 ......
                payPrdOfHotelVerify(orderInfo);
                // 信用支付
                long payId = payService.payOfCredit(orderInfo);
                // 如果支付失败关闭订单
                if(payId < 0) {
                    payService.notPayedToClose(orderInfo);
                }
            }
            // 门票订单
            else if ("tickets".equals(orderBizType)) {
                long payId = -1;
                for (int i = 0; i < 3; i++) { // 如果失败有3次重试
                    // 信用支付
                    payId = payService.payOfCredit(orderInfo);
                    // payId >0 代表支付成功
                    if (payId > 0) {
                        break;
                    }
                }
                // 如果支付失败关闭订单
                if(payId < 0) {
                    payService.notPayedToClose(orderInfo);
                }
            }
            // 签证订单
            else if ("visa".equals(orderBizType)) {
                // 三方支付
                long payId = payService.payOfAliPay(orderInfo);
                // 如果支付失败关闭订单
                if(payId < 0) {
                    payService.notPayedToClose(orderInfo);
                }
                // 如果支付成功
                else {
                    // 签证订单支付后业务上要处理的一些逻辑
                    payAfterOfVisaBusiness(payId, orderInfo);
                }
            }
        } else if (4 == status) { // 订单完成
            // 酒店订单
            if ("hotel".equals(orderBizType)) {
                // 更新订单状态
                orderService.updateOrderStatus(orderNo, 4);
                // 给运营发钉钉通知
                notifyService.dingding("发送到酒店运营群里的内容");
                // 给用户发短信
                notifyService.sms("发送到给酒店用户的内容");
            }
            // 门票订单
            else if ("tickets".equals(orderBizType)) {
                // 更新订单状态
                orderService.updateOrderStatus(orderNo, 4);
                // 给运营发钉钉通知
                notifyService.dingding("发送到门票运营群里的内容");
                // 给用户发短信
                notifyService.sms("发送到给门票用户的内容");
                // 给用户发微信通知
                notifyService.wechat("发送到给门票用户的内容");
            }
            // 签证订单
            else if ("visa".equals(orderBizType)) {
                // 更新订单状态
                orderService.updateOrderStatus(orderNo, 4);
                // 给运营发钉钉通知
                notifyService.dingding("发送到签证运营群里的内容");
                // 给用户发微信通知
                notifyService.wechat("发送到给签证用户的内容");
            }
        }
        // 同意退款 待未来业务扩展......
        else if (9 == status) {

        }
         */

    }



    private void payPrdOfHotelVerify(OrderInfo orderInfo) {
        // 各种酒店订单支付前的检查 ...... 候选人不用关系内部逻辑
    }
    private void payAfterOfVisaBusiness(long payId, OrderInfo orderInfo) {
        // 各种签证订单支付后的逻辑 ...... 候选人不用关系内部逻辑
    }


}
