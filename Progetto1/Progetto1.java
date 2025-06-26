/*Esercizio di gruppo: Gestione di un concorso fotografico
In un concorso fotografico sono stati raccolti i voti dei giudici per 5
fotografie finaliste.
Scrivi un programma Java che:
Usando un array di interi, memorizzi i voti da 1 a 10 assegnati a 5 foto. 
Usi un ciclo for per inserire i voti uno alla volta. 
Ogni voto deve essere compreso tra 1 e 10:
Se il voto è fuori range, deve essere scartato e richiesto nuovamente. 
Alla fine, il programma deve:
- Stampare quali foto sono state premiate, ovvero:
- Foto con voto maggiore o uguale a 8 e pari (uso dell'operatore %)
- Stampare il numero totale di foto premiate
Stampare “Concorso annullato” se nessuna foto ha ricevuto almeno 6 punti */

import java.util.Scanner;

public class Progetto1 {
    public static void main(String[] args) {
        //dichiarazione array per foto e voti
        int[] foto = {1, 2, 3, 4, 5};
        int[] voti = new int[foto.length];
        boolean valido = false;
        int fotoPremiate = 0;

        //Inizializzo uno scanner per gli input
        Scanner scanVoti = new Scanner(System.in);

        //INserisco attraverso un ciclo for i voti per ogni foto
        for (int i = 0; i < voti.length; i++) {
            //Output guida
            System.out.println("Inserisci voto per foto " + (i + 1) + ":");
            //assegnazione input alla variabile
            voti[i] = scanVoti.nextInt();

            //verifico la correttezza del voto in range 1-10
            while (voti[i] < 1 || voti[i] > 10) {
                //Output guida
                System.out.println("Inserisci un voto valido per foto " + i + ":");
                //assegnazione input alla variabile
                voti[i] = scanVoti.nextInt();
            }
        }

        //effettuo la verifica dei voti >= 6 per la validita del concorso e la verifica di voti >= 8 se pari per essere premiati
        for (int i = 0; i < foto.length; i++) {
            if (voti[i] >= 6) {
                valido = true;
                if (voti[i] >= 8 && voti[i] % 2 == 0) {
                    //incremento la variabile foto premiate 
                    fotoPremiate++;
                }
            }
        }

        //attraverso la condizione specifico se il concorso è valido e quante foto vanno a premiazione
        if (valido) {
            if (fotoPremiate != 0) {
                System.out.println("Le foto premiate sono: " + fotoPremiate);
            } else {
                System.out.println("Non ci sono foto premiate");
            }
        } else {
            System.out.println("Concorso annullato");
        }
        
        //chiusura scanner
        scanVoti.close();
    }
}
