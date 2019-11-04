/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.lez00;

import javax.swing.JOptionPane;

/**
 *
 * @author tss
 */
public class FirstApp {

    /**
     * metodo principale
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println(1234);
        String nomefornito;
        String frasesaluto = "Benvenuto";
        String risultato = "";
        int sogliacontanti = 3000;
        int sogliacarta = 5000;

        int costospedizione = 50;
        int sogliaspesa = 1000;
        int costopackaging = 5;
        String msgSpedizione;
        float qta;
        float perc;
        float prezzo;
        float prezzofinale;
        int cod;
        String strprezzo = JOptionPane.showInputDialog("dimmi il prezzo");
        prezzo = Float.parseFloat(strprezzo);
        String strqta = JOptionPane.showInputDialog("dimmi la quantità");
        qta = Float.parseFloat(strqta);
        String strperc = JOptionPane.showInputDialog("dimmi lo sconto");
        perc = Float.parseFloat(strperc);

        try {
            String strcod = JOptionPane.showInputDialog("dimmi codice tipo cliente (es. 1,2 o 3)");
            cod = Integer.parseInt(strcod);
        } catch (Exception err) {
            cod = 1;
            JOptionPane.showMessageDialog(null, "hai scritto un cod errato e ti "
                    + "e' stato messo il cod 1 di fornitore locale");
        }

        prezzofinale = prezzo * qta - (prezzo * qta * perc / 100);
        // se prezzofinale minore di sogliaSpese allora 
        //aggiungo al prezzofinale il cost di spedizione
        // altrimenti non faccio niente
        if (prezzofinale <= sogliaspesa) {
            //aggiungo spese
            //prezzofinale += costospedizione + costopackaging*qta;
            prezzofinale = prezzofinale + costospedizione + costopackaging * qta;

            //preparo messaggio spese
            msgSpedizione = "Applicato costo di spedizione di " + costospedizione
                    + "€ perche' inferiore a spesa minima di " + sogliaspesa + "€  + packaging";
        } else {
            msgSpedizione = "Nessun costo di spedizione di " + costospedizione
                    + "€ applicato perche' hai superato la spesa di " + sogliaspesa + "€";
        }

        nomefornito = JOptionPane.showInputDialog("dimmi un nome");
        risultato = frasesaluto;
        risultato = risultato + " ";
        risultato = risultato + nomefornito;
        risultato += "\nmi devi " + prezzofinale + " euro";
        // se prezzofinale sotto sogliacontanti messaggio ok
        // altrimenti messaggio bonifico
        if (prezzofinale <= sogliacontanti) {
            risultato += "\npuoi pagare anche in contanti";
        } else { //caso >3000
            // devo vedere se carta o bonifico
            if (prezzofinale > sogliacontanti && prezzofinale < sogliacarta) {
                risultato += "\npuoi pagare solo  con bonifico o carta";
            } else {
                risultato += "\npuoi pagare solo  con bonifico";
            }
        }

        risultato += "\n" + msgSpedizione;
        if (!(qta > 50 || prezzofinale > 2000) || perc == 0) {
            risultato += "\ncliente basic";
        } else {
            risultato += "\ncliente gold";
        }
        String msgCod;
        switch (cod) {
            case 1:
                msgCod = "\nFornitore locale";
                break;
            case 2:
                msgCod = "\nFornitore Estero";
                break;
            default:
                msgCod = "\nFornitore Altro";

        }
        
        risultato += msgCod;

        JOptionPane.showMessageDialog(null, risultato);
        // TODO code application logic here
    }
}
