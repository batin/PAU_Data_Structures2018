
class Araba implements Comparable<Araba> {
    public int modelYili;
    public String plaka;
    public String marka;
    public double motorHacmi;

  public Araba(String marka,int modelYili,double motorHacmi,String plaka){
    this.marka = marka;
    this.modelYili = modelYili;
    this.motorHacmi = motorHacmi;
    this.plaka = plaka;
  }

    public int compareTo(Araba a1){
        return this.modelYili-a1.modelYili;
    }
}
