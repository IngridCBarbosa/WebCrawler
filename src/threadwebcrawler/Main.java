package threadwebcrawler;

import java.io.IOException;

/**
 *
 * @author Ingrid
 */
public class Main {

    public static void main(String[] args) throws IOException {
        
       CheckBuffer cb = new CheckBuffer();
        
        cb.link();
        
        
        
      /*WebCrawler w = new WebCrawler();
        w.getPageLinks("https://www.adidas.com.br");
        // https://dragonpharmabrasil.com  https://www.mithoficial.com.br https://www.netshoes.com.br
        // https://www.lojaelshaddaigourmet.com.br  https://www.saraiva.com.br  https://www.americanas.com.br  
        System.out.println(Buffer.getURL());
        w.download();
        */
    }
    
}
