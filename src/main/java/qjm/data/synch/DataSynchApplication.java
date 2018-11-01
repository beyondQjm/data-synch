package qjm.data.synch;

import qjm.data.synch.offline.OffLineSynch;
import qjm.data.synch.online.OnlineSynch;

/**
 * 程序入口
 */
public class DataSynchApplication {

    public static void main(String[] args) {
        //离线数据同步
        //OffLineSynch offLineSynch = new OffLineSynch();
        //offLineSynch.synchToHbase();
        //offLineSynch.synchFromHbase();

        //实时数据同步
        OnlineSynch onlineSynch = new OnlineSynch();
        onlineSynch.synchToHbase();

    }

}
