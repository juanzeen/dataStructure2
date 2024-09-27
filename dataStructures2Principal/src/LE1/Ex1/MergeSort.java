package LE1.Ex1;

//A ideia é dividir o vetor até que fiquem somente elementos unitários;
//Com isso, ele é novamente montado de forma recursiva e comparando os subvetores pelo caminho.
public class MergeSort {

    public static void merge(int[] array, int base, int mid, int top) {

        //Nesse abordagem não vamos literalmente quebras um vetor maior em dois subvetores, vamos simular essa ideia.
        //Utilizaremos um vetor auxiliar e temporário, que é criado e destruído a cada iteração do sort;
        //Nele copiamos elemento por elemento do nosso vetor original.
        int[] helper = new int[array.length];
        for (int i = base; i <= top; i++) {
            helper[i] = array[i];
        }

        //Criamos iteradores para fazer a organização, o i recebe o valor da base, que será 0 no lado esquerdo e também pode ser outro quando passamos mid + 1
        //j = é iniciado como mid + 1, analisa o que tem depois da metade no nosso vetor auxiliar

        int i = base;
        int j = mid + 1;
        int k = base;

        //Percorre o vetor com dois iteradoes, um na base e outro que começa no primeiro elemento pois o central
        while (i <= mid && j <= top) {
        //Simula as comparações em dois vetores diferentes em um vetor só, com base nisso faz comparações e insere no vetor final
            if (helper[i] <= helper[j]) {
                array[k] = helper[i];
                i++;
            } else {
                array[k] = helper[j];
                j++;
            }
            k++;

        }

      //Caso tenha estourado o while com base em j, aqui inserimos os elementos da primeira metade do nosso vetor
        //Essa condição é dada somente a primeira metade justamente por estarmos simulando que temos dois vetores, quando na verdade temos só um.
        //Com isso, não há necessidade de preocupação caso o loop de cima tenha estourado com base em i, pois de toda forma a segunda metade já está inserida no vetor
        while (i <= mid) {
            array[k] = helper[i];
            i++;
            k++;
        }


    }

    public static int[] sort(int[] array, int base, int top){
        if(base < top){
            int mid = (base + top)/2;
            MergeSort.sort(array, base, mid);
            MergeSort.sort(array, mid+1, top);
            MergeSort.merge(array, base, mid, top);
        }
        return array;
    }

}
