public class Kernel {
  float[][]kernel;
  
  /*Constructor takes the kernel that will be applied to the image
    This implementation only allows 3x3 kernels*/
  public Kernel(float[][]init) {
   kernel = init;
  }

  /*If part of the kernel is off of the image, return black, Otherwise
    Calculate the convolution of r/g/b separately, and return that color
  */
  color calcNewColor(PImage img, int x, int y) {
    if (x >= img.width-1 || x  < 1 || y  >= img.height-1 || y < 1) {
      return color(0, 0, 0);
    }
    else {
      int new_now = 0;
      
      for (int i = 0; i<3; i++) {
        for (int j = 0; j < 3; j++) {
           int now = img.get(x + (i-1), y + (j-1));
           now *= kernel[i][j];
           print(now);
           new_now += now;
           print(new_now);
        }
      }
      return new_now/9;
    }
  }


  /*Assume the destination is the same dimensions as the source.

  */
  void apply(PImage source, PImage destination) {
     for (int y = 0; y<source.height;y++){
     for (int x = 0; x<source.width;x++) {
     destination.set(x, y, calcNewColor(source, x, y));
}
}
  }

}
void setup(){
  size(1450,500);
  PImage car = loadImage("redcar.jpg");
  PImage output = car.copy();
  Kernel k = new Kernel( new float[][]    { {0.111, 0.111, 0.111},
     {0.111, 0.111, 0.111},
   {0.111, 0.111, 0.111} } );
  k.apply(car,output);
  image(car,0,0);
  image(output,car.width,0);
}
