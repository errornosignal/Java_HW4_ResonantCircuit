/**
 * Class for determining values of resonant circuits, includes sub-classes for parallel and series
 * @author Reid Nolan
 * @version 1.0
 * Created on 3/23/2017.
 */
public class ResonantCircuit
{
    double Wo;
    double B;
    double k;

    /**
     * constructor for ResonantCircuit
     */
    public ResonantCircuit()
    {
        this.Wo = 0;
        this.B = 0;
        this.k = 0;
    }

    /**
     * setter
     * sets values of ResonantCircuit objects
     * @param Wo frequency
     * @param B bandwidth
     * @param k gain
     */
    public void setValues(double Wo, double B, double k)
    {
        this.Wo = Wo;
        this.B = B;
        this.k = k;
    }

    /**
     * getter
     * gets values of ResonantCircuit objects
     * @return this.Object
     */
    public ResonantCircuit getValues()
    {
        return this;
    }

    /**
     * displays values of ResonantCircuit objects
     * @return resonantString
     */
    @Override
    public String toString()
    {
        return "-Frequency(Wo): " + this.Wo + "\n" +
                "-Bandwidth(B): " + this.B + "\n" +
                "-Gain(k): " + this.k;
    }

    /**
     * Sub-class of ResonantCircuit for determining ParallelResonantCircuit values
     * @author Reid Nolan
     * @version 1.0
     * Created on 3/23/2017.
     */
    public static class ParallelResonantCircuit extends ResonantCircuit
    {
        private double R;
        private double L;
        private double C;

        /**
         * constructor for ParallelResonantCircuit
         */
        public ParallelResonantCircuit()
        {
            super();
            this.R = 0;
            this.L = 0;
            this.C = 0;
        }

        /**
         * setter
         * sets values of SeriesResonantCircuit objects
         * @param Wo frequency
         * @param B bandwidth
         * @param k gain
         */
        public void setValues(double Wo, double B, double k)
        {
            super.setValues(Wo, B, k);
            this.R = k;
            this.C = 1 / (B * this.R);
            this.L = 1 / (Wo * Wo * this.C);
        }

    /**
     * getter
     * gets values of ParallelResonantCircuit objects
     * @return this.Object
     */
    public ParallelResonantCircuit getValues()
    {
    return this;
    }

        /**
         * displays values of ParallelResonantCircuit objects         *
         * @return parallelString
         */
        @Override
        public String toString()
        {
            System.out.println("[Parallel Resonant Circuit]");
            return "-Frequency(Wo): " + this.Wo + "\n" +
                    "-Bandwidth(B): " + this.B + "\n" +
                    "-Gain(k): " + this.k + "\n" +
                    "-Resistance(R): " + this.R + "\n" +
                    "-Capacitance(C): " + this.C + "\n" +
                    "-Inductance(L): " + this.L + "\n";
        }
    }

    /**
     * Sub-class of ResonantCircuit for determining SeriesResonantCircuit values
     * @author Reid Nolan
     * @version 1.0
     * Created on 3/23/2017.
     */
    static class SeriesResonantCircuit extends ResonantCircuit
    {
        private double R;
        private double L;
        private double C;

        /**
         * constructor for SeriesResonantCircuit
         */
        public SeriesResonantCircuit()
        {
            super();
            this.R = 0;
            this.L = 0;
            this.C = 0;
        }

        /**
         * setter
         * sets values of SeriesResonantCircuit objects
         * @param Wo frequency
         * @param B bandwidth
         * @param k gain
         */
        @Override
        public void setValues(double Wo, double B, double k)
        {
            super.setValues(Wo, B, k);
            this.R = 1 / k;
            this.L = this.R / B;
            this.C = 1 / (Wo * Wo * this.L);
        }

        /**
         * getter
         * gets values of SeriesResonantCircuit objects
         * @return this.Object
         */
       public SeriesResonantCircuit getValues()
        {
            return this;
        }

        /**
         * displays values of SeriesResonantCircuit objects
         * @return seriesString
         */
        @Override
        public String toString()
        {
            System.out.println("[Series Resonant Circuit]");
            return "-Frequency(Wo: " + this.Wo + "\n" +
                    "-Bandwidth(B): " + this.B + "\n" +
                    "-Gain(k): " + this.k + "\n" +
                    "-Resistance(R): " + this.R + "\n" +
                    "-Capacitance(C): " + this.C + "\n" +
                    "-Inductance(L): " + this.L + "\n";
        }
    }
}