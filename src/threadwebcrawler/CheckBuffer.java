
package threadwebcrawler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ingrid
 */
public class CheckBuffer {
    public void link() throws FileNotFoundException, IOException{
       
        BufferedReader br = new BufferedReader(new FileReader("links.txt"));
        String linha;
        
        while((linha = br.readLine()) != null){
            System.out.println(linha);
            Runnable runnable = new PageLinkThread(linha);
            Thread t = new Thread(runnable);
            t.start();
            
        }
    }
    
}
