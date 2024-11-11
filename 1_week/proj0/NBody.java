import java.util.Arrays;
class NBody {
    public static double readRadius(String universe) {
        In in = new In(universe);
        int numOfPlanets = in.readInt();
        double universeRadius = in.readDouble();
        return universeRadius;
    }

    public static Body[] readBodies(String universe) {
        In in = new In(universe);
        int numOfPlanets = in.readInt();
        double universeRadius = in.readDouble();

        Body[] bodies = new Body[numOfPlanets];

        for (int i = 0; i < bodies.length; i++) {
            double xxPos = in.readDouble();
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String img = in.readString();
            Body newBody = new Body(xxPos, yyPos, xxVel, yyVel, mass, img);
            bodies[i] = newBody;
        }
        return bodies;
    }

    public static void displayBackground(double universeRadius) {
        StdDraw.setScale(-universeRadius, universeRadius);
        StdDraw.clear();
        StdDraw.picture(0, 0, "./images/starfield.jpg");
        StdDraw.show();
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Please provide arguments");
            return;
        }

        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];

        double universeRadius = readRadius(filename);
        Body[] bodies = readBodies(filename);

        displayBackground(universeRadius);
        for (int i = 0; i < bodies.length; i++) {
            bodies[i].draw();
        }

        StdDraw.enableDoubleBuffering();
        double time = 0.0;
        while (time <= T) {
            double[] xForces = new double[bodies.length];
            double[] yForces = new double[bodies.length];
            for (int i = 0; i < bodies.length; i++) {
                xForces[i] = bodies[i].calcNetForceExertedByX(bodies);
                yForces[i] = bodies[i].calcNetForceExertedByY(bodies);
            }
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].update(dt, xForces[i], yForces[i]);
            }
            displayBackground(universeRadius);
            for (int i = 0; i < bodies.length; i++) {
                bodies[i].draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdOut.printf("%d\n", bodies.length);
        StdOut.printf("%.2e\n", universeRadius);
        for (int i = 0; i < bodies.length; i++) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                    bodies[i].xxPos, bodies[i].yyPos, bodies[i].xxVel,
                    bodies[i].yyVel, bodies[i].mass, bodies[i].imgFileName);
        }
    }
}