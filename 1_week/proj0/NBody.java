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
        System.out.println(universeRadius);
        System.out.println(Arrays.toString(bodies));
    }
}