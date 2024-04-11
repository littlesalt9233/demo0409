package me.example.test.model;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class Demo {


    static class RoomType {

        private String roomId;
        private String hotelId;
        private BigDecimal price;

        public RoomType() {
        }

        public String getRoomId() {
            return roomId;
        }

        public void setRoomId(String roomId) {
            this.roomId = roomId;
        }

        public String getHotelId() {
            return hotelId;
        }

        public void setHotelId(String hotelId) {
            this.hotelId = hotelId;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "RoomType{" +
                    "roomId='" + roomId + '\'' +
                    ", hotelId='" + hotelId + '\'' +
                    ", price=" + price +
                    '}';
        }
    }

    // 求酒店下所有房型的平均价格大于500的所有酒店，按照平均价格倒序，取前第21行到第60行房型Id。
    // 表结构：house_type （房型表） {id（房型ID）, hotel_id（酒店ID）, price（房型价格)}
    // 业务背景：酒店与房型的关系是1对多。
    // 房型有：大床房、标间、豪华大床房等等。酒店的平均价格是由房型上的价格决定的。
    public static void main(String[] args) {
        List<RoomType> roomTypeList = testRoomData();
        //打印房型数据
        //roomTypeList.forEach(e -> System.out.println(e));
        //
        HashMap<String, RoomType> roomMap = filter(roomTypeList, 500,21,60);
        //按照平均价格倒序，取前第21行到第60行房型Id
        roomMap.keySet().forEach(e -> System.out.println( roomMap.get(e)));


    }

    /**
     * 根据平均价格筛选,倒叙获取对应行数记录
     * @param rowData 未处理数据
     * @param avgPrice 价格
     * @param getRows 获取对应行
     * @return List<RoomType>
     * */
    public static HashMap<String, RoomType> filter(List<RoomType> rowData,int avgPrice,int... getRows){
        Map<String, List<RoomType>> collect = rowData.stream().collect(Collectors.groupingBy(RoomType::getHotelId));
        //遍历分组对象
        Map<String, List<RoomType>> matchMap = new HashMap<>();
        collect.keySet().forEach(key ->{
            //酒店下所有房型高于500
            List<RoomType> roomTypes = collect.get(key);
            boolean allMatch = roomTypes.stream().anyMatch(room -> room.getPrice().compareTo(new BigDecimal(avgPrice)) < 0);
            if(!allMatch){
                matchMap.put(key,collect.get(key));
            }
        });
        //全部大于平均价格的集合
        Set<String> hotelIds = matchMap.keySet();
        ArrayList<RoomType> allAvgPriceList = new ArrayList<>();
        hotelIds.forEach(key -> {
            List<RoomType> roomTypes = matchMap.get(key);
            allAvgPriceList.addAll(roomTypes);
        });
        //倒序
        List<RoomType> matchRoomTypeList = allAvgPriceList.stream().sorted((a, b) -> b.getPrice().compareTo(a.getPrice())).collect(Collectors.toList());
        HashMap<String, RoomType> typeHashMap = new HashMap<>(4);
        for (int getRow : getRows) {
            typeHashMap.put(String.valueOf(getRow) ,matchRoomTypeList.get(getRow));
        }
        return typeHashMap;

    }

    /**
     *
     */
    public static List<RoomType> testRoomData() {
        //10间酒店
        int hotelTypeRecord = 10;
        //房型
        int roomRoomTypeRecord = 3;
        //数据记录
        ArrayList<RoomType> roomList = new ArrayList<>();
        for (int i = 0; i < hotelTypeRecord; i++) {
            for (int j = 0; j < roomRoomTypeRecord * 100; j++) {
                RoomType aRoom = new RoomType();
                aRoom.setHotelId("hotel_" + (i + 1));
                aRoom.setRoomId("room_" + ((j % roomRoomTypeRecord) + 1));
                aRoom.setPrice(getRangRandom(j % roomRoomTypeRecord,(i + 1)));
                roomList.add(aRoom);
            }

        }
        return roomList;
    }

    /**
     * 构造一些房型数据
     *
     * @param roomType 1：100~200随机数 2：200~300随机数 3：500~600随机数
     * @param round
     * @return BigDecimal = roomType * round
     */
    public static BigDecimal getRangRandom(int roomType, int round) {
        Random random = new Random();
        switch (roomType) {
            case 0:
                return new BigDecimal((random.nextInt(100) + 100) * round);
            case 1:
                return new BigDecimal((random.nextInt(100) + 200) * round);
            case 2:
                return new BigDecimal((random.nextInt(100) + 500) * round);
            default:
                return new BigDecimal(0);
        }
    }
}
