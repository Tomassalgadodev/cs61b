class Body {
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
    static final double gravConst = 6.667e-11;

    public Body(double xP, double yP, double xV, double yV, double m, String img) {
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = m;
        imgFileName = img;
    }

    public Body(Body b) {
        this.xxPos = b.xxPos;
        this.yyPos = b.yyPos;
        this.xxVel = b.xxVel;
        this.yyVel = b.yyVel;
        this.mass = b.mass;
        this.imgFileName = b.imgFileName;
    }

    public double calcDistance(Body b) {
        double xxSquared = Math.pow((this.xxPos - b.xxPos), 2);
        double yySquared = Math.pow((this.yyPos - b.yyPos), 2);
        double distance = Math.sqrt(xxSquared + yySquared);
        return distance;
    }

    public double calcForceExertedBy(Body b) {
        double distance = this.calcDistance(b);
        double force = (gravConst * this.mass * b.mass) / Math.pow(distance, 2);
        return force;
    }

    public double calcForceExertedByX(Body b) {
        double distance = this.calcDistance(b);
        double force = this.calcForceExertedBy(b);
        double dx = b.xxPos - this.xxPos;
        double forceExertedByX = (force * dx) / distance;
        return forceExertedByX;
    }

    public double calcForceExertedByY(Body b) {
        double distance = this.calcDistance(b);
        double force = this.calcForceExertedBy(b);
        double dy = b.yyPos - this.yyPos;
        double forceExertedByY = (force * dy) / distance;
        return forceExertedByY;
    }

    public double calcNetForceExertedByX(Body[] bodies) {
        double netXForce = 0;
        for(int i = 0; i < bodies.length; i++) {
            if (!this.equals(bodies[i])) {
                double xForce = this.calcForceExertedByX(bodies[i]);
                netXForce += xForce;
            }
        }
        return netXForce;
    }

    public double calcNetForceExertedByY(Body[] bodies) {
        double netYForce = 0;
        for(int i = 0; i < bodies.length; i++) {
            if (!this.equals(bodies[i])) {
                double yForce = this.calcForceExertedByY(bodies[i]);
                netYForce += yForce;
            }
        }
        return netYForce;
    }

    public void update(double dt, double fX, double fY) {
        double accelX = fX / this.mass;
        double accelY = fY / this.mass;
        double newXVel = this.xxVel + (dt * accelX);
        double newYVel = this.yyVel + (dt * accelY);
        double newXPosition = this.xxPos + (dt * newXVel);
        double newYPosition = this.yyPos + (dt * newYVel);
        this.xxVel = newXVel;
        this.yyVel = newYVel;
        this.xxPos = newXPosition;
        this.yyPos = newYPosition;
    }

    public void draw() {
        String filePath = "./images/" + this.imgFileName;
        StdDraw.picture(this.xxPos, this.yyPos, filePath);
    }
}