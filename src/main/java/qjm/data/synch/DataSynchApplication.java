package qjm.data.synch;

import qjm.data.synch.offline.OffLineSynch;

/**
 * 程序入口
 */
public class DataSynchApplication {

    public static void main(String[] args) {
        //离线数据同步
        OffLineSynch offLineSynch = new OffLineSynch();
        //offLineSynch.synchToHbase();
        offLineSynch.synchFromHbase();

    }

}
