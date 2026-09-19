class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int x1, int y1, int x2, int y2) {
        int dx = Math.max(x1 - xCenter, Math.max(0, xCenter - x2));
        int dy = Math.max(y1 - yCenter, Math.max(0, yCenter - y2));

        return dx * dx + dy * dy <= radius * radius;
    }
}