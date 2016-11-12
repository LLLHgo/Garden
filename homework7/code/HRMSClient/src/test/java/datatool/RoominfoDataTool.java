package datatool;

import java.util.ArrayList;
import java.util.List;

import Enum.RoomState;
import vo.hotelinfoVO.RoominfoVO;

public class RoominfoDataTool {
	static RoominfoVO roominfo1 = new RoominfoVO("标准间","8304",200, RoomState.Usable);
	static RoominfoVO roominfo2 = new RoominfoVO("标准间","8305",200, RoomState.Usable);
	static RoominfoVO roominfo3 = new RoominfoVO("大床房","8306",200, RoomState.Usable);
	static RoominfoVO roominfo4 = new RoominfoVO("标准间","8307",200, RoomState.Usable);
	static RoominfoVO roominfo5 = new RoominfoVO("标准间","8308",200, RoomState.Unusable);
	static RoominfoVO roominfo6 = new RoominfoVO("大床房","8309",200, RoomState.Unusable);
	static{
		List<RoominfoVO> list = new ArrayList<RoominfoVO>();
		list.add(roominfo1);
		list.add(roominfo2);
		list.add(roominfo3);
		list.add(roominfo4);
		list.add(roominfo5);
		list.add(roominfo6);
	}
}
