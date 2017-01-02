package datatool;

import java.util.ArrayList;
import java.util.List;

import vo.levelVO.LevelVO;

public class LevelDataTool {
    public static LevelVO v1=new LevelVO(1,"铜牌",1000,0.95);
    public static LevelVO v2=new LevelVO(2,"银牌",2000,0.9);
    public static LevelVO v3=new LevelVO(3,"金牌",3000,0.8);
    public static List<LevelVO> list=new ArrayList<LevelVO>();
    static {
    	list.add(v1);
    	list.add(v2);
    	list.add(v3);
    }

}
