ArrayList<Cow> particles;
void setup() {
  size(1000, 800);
  particles = new ArrayList<Cow>();
  for (int i = 0; i < 100; i++)
    particles.add(new Cow());
}

void draw() {
  background(200);
  for (Cow c : particles) {
    c.move();
    c.display();
  }
  fill(0);
  textSize(20);
  text("FPS: "+frameRate+"\nCows: "+particles.size(),0,20);
}

void mousePressed() {
   //Read about mouseClicked()/mousePressed() and related methods in the documentation.
   //Right click: add a cow at the mouse location.
   //Left click: call the click of each cow
   if (mousePressed && (mouseButton == RIGHT)) {
      particles.add(new Cow(20+(int)(Math.random()*30), mouseX, mouseY, 
    random(6)-3,
    random(6)-3));
   }
   if (mousePressed && (mouseButton == LEFT)) {
     for(int i = 0; i < particles.size(); i++) {
       particles.get(i).click();
     }
   }
}

void keyPressed() {
  if(keyCode == 32) {
    particles.clear();
  }
}

public class Cow {
  float x, y, dx, dy, radius;
  color c;
  boolean colliding;
  boolean selected;
  Cow(float rad, float x, float y, float dx, float dy) {
    radius = rad;
    this.x = x;
    this.y = y;
    this.dx = (int)(dx*100)/100.0;
    this.dy = (int)(dy*100)/100.0;
    c = color(random(255),random(255),random(255));

  }
  Cow() {
    this(20+(int)(Math.random()*30), width/2, height/2, 
    random(6)-3,
    random(6)-3);
  }
  
  void move() {
    if (colliding && selected) {
      x += dx;
      y += dy;
    }
    x += dx;
    y += dy;
    if (x >= width - radius || x <= radius) dx *= -1;
    if (y >= height - radius || y <= radius) dy *= -1;
    
  }
  
  void collide() {
    colliding = false;
    for(int i = 0; i < particles.size(); i++) {
       if ((radius + particles.get(i).radius) > dist(x, y, particles.get(i).x, particles.get(i).y)) {
         if (x == particles.get(i).x && y == particles.get(i).y && radius == particles.get(i).radius) {
         } else {
           colliding = true;
         }
       } 
    }

  
  }
  void display() {
    collide();
    stroke(0);
    if (colliding) {
      fill(color(255, 0, 0, 30));
    } else {
      fill(c);
    }
    ellipse(x, y, radius*2, radius*2);
    if (selected) {
      ellipse(x - radius/3, y - radius/5, radius/2, radius/2);
      ellipse(x + radius/3, y - radius/5, radius/2, radius/2);
      arc(x, y + radius/5, radius/2, radius/2, 0, radians(180), PIE);
      text(String.valueOf(x), x + radius, y, radius, radius);
      text(String.valueOf(y), x + radius, y + radius/2, radius, radius);
    }
    
    
  }

  void click(){
   //if the mouseX and mouseY are touching this cow, change the cow somehow.
    if(dist(mouseX, mouseY, x, y) <= radius) {
      selected = !selected;
    }
  }

}
