class Solution {
    public double separateSquares(int[][] squares) {
        long totalArea = 0;
        for (int[] sq : squares) {
            totalArea += 1L * sq[2] * sq[2];
        }
        double half = totalArea / 2.0;

        // 2. Create sweep events: (y, deltaWidth)
        List<double[]> events = new ArrayList<>();
        for (int[] sq : squares) {
            double y = sq[1];
            double len = sq[2];
            events.add(new double[]{y, len});        // square starts
            events.add(new double[]{y + len, -len}); // square ends
        }

        // 3. Sort events by y
        events.sort((a, b) -> Double.compare(a[0], b[0]));

        double prevY = events.get(0)[0];
        double activeWidth = 0.0;
        double areaSoFar = 0.0;

        // 4. Sweep line
        for (double[] e : events) {
            double currY = e[0];
            double deltaY = currY - prevY;

            double areaAdded = activeWidth * deltaY;

            // If crossing half area, interpolate exact y
            if (areaSoFar + areaAdded >= half) {
                double remaining = half - areaSoFar;
                return prevY + remaining / activeWidth;
            }

            areaSoFar += areaAdded;
            activeWidth += e[1];
            prevY = currY;
        }

        return prevY; 
    }
}