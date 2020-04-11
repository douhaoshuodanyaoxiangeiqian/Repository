package Hotel;

public class DP implements IData {

	private static String[][]rooms;

	@Override
	public void iniRooms() {
		rooms=new String[HotelConstant.HOTEL_TOTAL_FLOOR]
				[HotelConstant.HOTEL_ROOMS_EVERYFLOOR];
		for (int i = 0; i < HotelConstant.HOTEL_TOTAL_FLOOR; i++) {
			for (int j = 0; j < HotelConstant.HOTEL_ROOMS_EVERYFLOOR; j++) {
				rooms[i][j]=HotelConstant.EMPTY;
			}
		}

	}
	
	public int roomNo(int roomNo){
		if(HotelConstant.EMPTY.equals(rooms[(roomNo/100)-1][(roomNo%100)-1]))
		{
			return roomNo;
		}
		else {
			return 0;
		}
	}

	@Override
	public String in_Out_Room(int roomNo, String name) {
		if (name.equals(HotelConstant.EMPTY)) {
			if (roomNo(roomNo)==0) {
				rooms[(roomNo/100)-1][(roomNo%100)-1]=name;
				return roomNo+"�˷��ɹ���";
			}else {
				return "�÷���û�п�����ס���˷�ʧ�ܣ�";
			}
		}else {
			if (roomNo(roomNo)==0) {
				return "�÷����Ѿ��п�����ס��";
			}else {
				rooms[(roomNo/100)-1][(roomNo%100)-1]=name;
				return name+"�ɹ���ס"+roomNo+"���䣡";
			}
		}
	}

	@Override
	public String getStation(int roomNo) {
		return rooms[(roomNo/100)-1][(roomNo%100)-1];
	}

}
