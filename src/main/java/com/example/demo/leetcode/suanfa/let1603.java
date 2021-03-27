package com.example.demo.leetcode.suanfa;

/**
 * 描述：设计停车系统
 *
 * @author yinjiaqi
 * @date 2021/3/27 14:36
 */
public class let1603 {
    class ParkingSystem {
        int a;
        int b;
        int c;

        public ParkingSystem(int big, int medium, int small) {
            this.a = big;
            this.b = medium;
            this.c = small;
        }

        public boolean addCar(int carType) {
            boolean flag = true;
            switch (carType) {
                case 1:
                    if (a < 1) {
                        flag = false;
                    }
                    a--;
                    break;
                case 2:
                    if (b < 1) {
                        flag = false;
                    }
                    b--;
                    break;
                case 3:
                    if (c < 1) {
                        flag = false;
                    }
                    c--;
                    break;
            }
            return flag;
        }
    }

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */

}
