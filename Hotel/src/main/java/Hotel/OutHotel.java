package Hotel;

public class OutHotel {
	IData iData;
	
	public OutHotel(IData iData){
		this.iData=iData;
	}
	
	public OutHotel(){
	}
	
	public String out(int roomNo, String name){
		return iData.in_Out_Room(roomNo, HotelConstant.EMPTY);
	}

}

/*public class OutHotel extends Empty{
public String out(int roomNo)
{
	MainRun mr=new MainRun();
	if(isEmpty(roomNo))
	{
		return "该房间没有客人入住，退房失败！";
	}
	else {
		mr.getRoom()[(roomNo/100)-1][(roomNo%100)-1]="EPMTY";
		return roomNo+"退房成功";
	}
}

}*/