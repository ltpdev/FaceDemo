package share.imooc.com.facedemo;

import java.util.List;

/**
 * Created by yls on 2017/4/18.
 */

public class FaceInfoBean {


    /**
     * result_num : 1
     * result : [{"location":{"left":115,"top":139,"width":143,"height":137},"face_probability":1,"rotation_angle":0,"yaw":0.13397297263145,"pitch":2.2589709758759,"roll":0.83776962757111,"age":31.975885391235,"beauty":60.171184539795}]
     * log_id : 290010630
     */

    private int result_num;
    private int log_id;
    /**
     * location : {"left":115,"top":139,"width":143,"height":137}
     * face_probability : 1
     * rotation_angle : 0
     * yaw : 0.13397297263145
     * pitch : 2.2589709758759
     * roll : 0.83776962757111
     * age : 31.975885391235
     * beauty : 60.171184539795
     */

    private List<ResultBean> result;

    public int getResult_num() {
        return result_num;
    }

    public void setResult_num(int result_num) {
        this.result_num = result_num;
    }

    public int getLog_id() {
        return log_id;
    }

    public void setLog_id(int log_id) {
        this.log_id = log_id;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * left : 115
         * top : 139
         * width : 143
         * height : 137
         */

        private LocationBean location;
        private int face_probability;
        private int rotation_angle;
        private double yaw;
        private double pitch;
        private double roll;
        private double age;
        private double beauty;

        public LocationBean getLocation() {
            return location;
        }

        public void setLocation(LocationBean location) {
            this.location = location;
        }

        public int getFace_probability() {
            return face_probability;
        }

        public void setFace_probability(int face_probability) {
            this.face_probability = face_probability;
        }

        public int getRotation_angle() {
            return rotation_angle;
        }

        public void setRotation_angle(int rotation_angle) {
            this.rotation_angle = rotation_angle;
        }

        public double getYaw() {
            return yaw;
        }

        public void setYaw(double yaw) {
            this.yaw = yaw;
        }

        public double getPitch() {
            return pitch;
        }

        public void setPitch(double pitch) {
            this.pitch = pitch;
        }

        public double getRoll() {
            return roll;
        }

        public void setRoll(double roll) {
            this.roll = roll;
        }

        public double getAge() {
            return age;
        }

        public void setAge(double age) {
            this.age = age;
        }

        public double getBeauty() {
            return beauty;
        }

        public void setBeauty(double beauty) {
            this.beauty = beauty;
        }

        public static class LocationBean {
            private int left;
            private int top;
            private int width;
            private int height;

            public int getLeft() {
                return left;
            }

            public void setLeft(int left) {
                this.left = left;
            }

            public int getTop() {
                return top;
            }

            public void setTop(int top) {
                this.top = top;
            }

            public int getWidth() {
                return width;
            }

            public void setWidth(int width) {
                this.width = width;
            }

            public int getHeight() {
                return height;
            }

            public void setHeight(int height) {
                this.height = height;
            }
        }
    }
}
