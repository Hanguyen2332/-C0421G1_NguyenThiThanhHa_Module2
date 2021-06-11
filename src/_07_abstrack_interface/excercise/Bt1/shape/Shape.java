package _07_abstrack_interface.excercise.Bt1.shape;

import _07_abstrack_interface.excercise.Bt1.Resizeable;

public abstract class Shape implements Resizeable {// Square là con của Shape. Square: implement Colorable --> vậy cha Shape có phải implement Colorable k?
        public abstract String getArea();
}
