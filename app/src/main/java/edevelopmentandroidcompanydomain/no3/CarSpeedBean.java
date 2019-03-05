package edevelopmentandroidcompanydomain.no3;

/**
 * Created by 15632 on 2019/3/5.
 */

public class CarSpeedBean {

    /**
     * serverInfo : {"CarSpeed":17}
     */

    private ServerInfoBean serverInfo;

    public ServerInfoBean getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(ServerInfoBean serverInfo) {
        this.serverInfo = serverInfo;
    }

    public static class ServerInfoBean {
        /**
         * CarSpeed : 17
         */

        private int CarSpeed;

        public int getCarSpeed() {
            return CarSpeed;
        }

        public void setCarSpeed(int CarSpeed) {
            this.CarSpeed = CarSpeed;
        }
    }
}
