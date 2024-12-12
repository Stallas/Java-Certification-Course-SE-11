package annotations;

enum Letter{
    Alpha(100), Beta(200),Gamma(300);
    int v;
    Letter(int v){
        this.v = v;
    }

    @Override
    public String toString() {
        return String.valueOf(v);
    }
}
