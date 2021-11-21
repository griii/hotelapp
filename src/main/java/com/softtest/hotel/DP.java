package com.softtest.hotel;

//DP��ʵ��IData�ӿ�
public class DP implements IData{
	private static String[][] rooms; // ��ʾ���� 
	MainRun mr = new MainRun(); 
	public void iniRooms() {
		rooms = new String[HotelConstant.HOTEL_TOTAL_FLOOR] [HotelConstant.HOTEL_ROOMS_EVERYFLOOR];
		
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++){
				rooms[i][j] = HotelConstant.EMPTY;
			}
		}
	}
		
		public String getStation(int roomNo){
			return rooms[( roomNo / 100 ) - 1 ][( roomNo % 100 ) - 1 ];
		}
		
		public int roomNo(int roomNo){
			if (HotelConstant.EMPTY.equals(rooms[( roomNo / 100 ) - 1 ] [ ( roomNo % 100 ) - 1 ])) {
				//��ʾ����Ϊ��			
				return roomNo;
			}
			else{
				//��ʾ����������ס
				return 0;
			}
		}

		public String in_Out_Room(int roomNo, String name) {
				//��name="EMPTY����ʾ�˷�
			if (name.equals(HotelConstant.EMPTY)){ 
				if(roomNo(roomNo)==0){
					rooms[ ( roomNo / 100 ) - 1 ][( roomNo % 100) - 1 ] = name;
					return roomNo+"�˷��ɹ�!";				 
				}
				else
					return "�÷���û�п�����ס,�˷�ʧ��!"; 
			}else if (roomNo(roomNo)==0){
				return"�÷����Ѿ��п�����ס!";
			}
			else{
				rooms[( roomNo / 100 ) - 1 ][( roomNo % 100 ) - 1 ] = name; 
				return name + "�ɹ���ס" + roomNo + "����!";
			}
		}



}
