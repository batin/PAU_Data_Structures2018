/**
 * Minimum heap sınıfı
 * @param <T> Generic sınıf
 */
public class BinaryHeap<T extends Comparable<T>> {
    public T[]  dizi;//Yığını tutacak dizi(değiştirmeyin)
    public int es;//Eleman sayısı(değiştirmeyin)

    public BinaryHeap() {//değiştirmeyin
        dizi=(T[]) new Comparable[100];
    }
    public BinaryHeap(int boyut){//değiştirmeyin
        dizi=(T[])new Comparable[boyut];
    }
    public int ebeveyn(int konum){ return konum/2;}//değiştirmeyin, kullanın
    public int solCocuk(int konum){ return 2*konum;}//değiştirmeyin, kullanın
    public int sagCocuk(int konum){return 2*konum+1;}//değiştirmeyin, kullanın
    public int elemanSayisi(){return es;}

  public void ekle(T eleman){
      dizi[++es] = eleman;
      T temp = null;
      int nodeIndex=es;
      while(nodeIndex != 1 && dizi[nodeIndex].compareTo(dizi[ebeveyn(nodeIndex)]) < 0){
      temp = dizi[ebeveyn(nodeIndex)];
      dizi[ebeveyn(nodeIndex)] = dizi[nodeIndex];
      dizi[nodeIndex] = temp;
      nodeIndex = ebeveyn(nodeIndex);
      }
  }

  public T sil(){
      T r = dizi[1];
  		dizi[1] = dizi[es];
  	  //dizi[es + 1] = null;
  		int x = 1;
  		T temp = null;
  		es--;
  		while ((sagCocuk(x) <= es || solCocuk(x) <= es)
            && (dizi[x].compareTo(dizi[sagCocuk(x)]) > 0
  			    || dizi[x].compareTo(dizi[solCocuk(x)]) > 0)) {
  			if (dizi[sagCocuk(x)].compareTo(dizi[solCocuk(x)]) > 0) {
  				temp = dizi[x];
  				dizi[x] = dizi[solCocuk(x)];
  				dizi[solCocuk(x)] = temp;
  				x = solCocuk(x);
  			}else{
  			 temp = dizi[x];
  			 dizi[x] = dizi[sagCocuk(x)];
  			 dizi[sagCocuk(x)] = temp;
  			 x = sagCocuk(x);
  			}
  		}
  		return r;
      }
  }
