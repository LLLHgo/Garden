package businesslogic.hoteinfobl;

import java.util.Comparator;

import vo.hotelinfoVO.HotelinfoVO;

public class SortRemarkStar implements Comparator<HotelinfoVO>{

	@Override
	public int compare(HotelinfoVO o1, HotelinfoVO o2) {
		//System.out.println(-o1.getRemarkstar()+o2.getRemarkstar());
		if(o1.getRemarkstar()-o2.getRemarkstar()>0){
			return -1;
		}else if(o1.getRemarkstar()-o2.getRemarkstar()<0){
			return 1;
		}else{
			return 0;
		}
	}
	
}
