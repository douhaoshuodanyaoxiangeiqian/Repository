package Hotel;

import java.util.Scanner;

public class MainRun {
	private static IData iData;
	private static ListHome lh;
	private static InHotel ih;
	private static OutHotel oh;
	
	public MainRun(){
		iData = new DP();
		lh = new ListHome(iData);
		ih = new InHotel(iData);
		oh = new OutHotel(iData);
	}
	public MainRun(IData iData){
		this.iData = iData;
		lh = new ListHome(iData);
		ih = new InHotel(iData);
		oh = new OutHotel(iData);
	}
	
	private static void iniRooms(){
		iData.iniRooms();
	}
	
	private static boolean validRoomNo(int roomNo){
		if((roomNo/100 > 10) ||(roomNo /100 < 1) || (roomNo%100>12) || (roomNo%100 < 1))
			return false;
		else
			return true;
	}
	
	private static void command(){
		String comm;
		while(true){
			System.out.println("请输入命令：");
			Scanner sca = new Scanner(System.in);
			System.gc();
			comm = sca.next();
			if("search".equalsIgnoreCase(comm)){
				lh.search();
			}
			else if("in".equalsIgnoreCase(comm)){
				int roomNo = sca.nextInt();
				try{
					if(validRoomNo(roomNo)){
						String name = sca.next();
						System.out.println(ih.in(roomNo, name));
					}
					else{
						System.out.println("房间号错！");
					}
				}catch(Exception e){
					System.out.println("房间号错！");
				}
			}
			else if("out".equalsIgnoreCase(comm)){
				int roomNo = sca.nextInt();
				if(validRoomNo(roomNo))
					System.out.println(oh.out(roomNo, HotelConstant.EMPTY));
				else {
					System.out.println("房间号错！");
				}
			}
			else if("exit".equalsIgnoreCase(comm)){
				System.out.println("程序退出...");
				break;
			}
			else {
				System.out.println("命令输入错误，请重新输入：");
			}
		}
	}
	
	public static void main(String[] args) {
		MainRun mr = new MainRun(new DP());
		mr.iniRooms();
		mr.command();
	}

}

/*public class MainRun {
private static String[][] rooms;
private static ListHome lh=new ListHome();
private static InHotel ih=new InHotel();
private static OutHotel oh=new OutHotel();

public static void main(String[] args){
	iniRooms();
	command();
}

private static void command() {
	String comm;
	while(true){
		System.out.println("请输入命令：");
		Scanner sca=new Scanner(System.in);
		System.gc();
		comm=sca.next();
		if ("search".equalsIgnoreCase(comm)) {
			lh.search();
		}else if ("in".equalsIgnoreCase(comm)) {
			int roomNo=sca.nextInt();
			try{
				if (validRoomNo(roomNo)) {
					String name=sca.next();
					System.out.println(ih.in(roomNo, name));
				}else {
					System.out.println("房间号错！");
				}
			}catch (Exception e) {
				System.out.println("房间号错！");
			}
		}else if ("out".equalsIgnoreCase(comm)) {
			int roomNo=sca.nextInt();
			String name=sca.next();
			if (validRoomNo(roomNo)) {
				System.out.println(oh.out(roomNo,name));
			}else {
				System.out.println("房间号错！");
			}
		}else if ("exit".equalsIgnoreCase(comm)) {
			System.out.println("程序退出……");
			break;
		}else {
			System.out.println("命令输入错误，请重新输入；");
		}
	}
}

private static boolean validRoomNo(int roomNo) {
	if ((roomNo/100>10)||(roomNo/100<1)||(roomNo%100>12)||(roomNo%100<1)) {
		return false;
	}else {
		return true;
	}
}

private static void iniRooms() {
	rooms=new String[10][12];
	for(int i=0;i<rooms.length;i++){
		for (int j = 0; j < rooms[0].length; j++) {
			rooms[i][j]="EMPTY";
		}
	}
}

public String[][]getRoom(){
	return rooms;
}

}*/