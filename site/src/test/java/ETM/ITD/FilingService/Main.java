package ETM.ITD.FilingService;

import java.io.FileInputStream;
import java.io.InputStream;

public class Main {
	
    public static void main(String args[])throws Exception{
        SignerUtil signerUtil=new SignerUtil();
        InputStream xmlFile=new FileInputStream("C:\\temp\\dsc\\x.zip");
        InputStream dscFile=new FileInputStream("C:\\Users\\admin\\Projects\\Mootly\\code\\wcm\\hippo\\solutions\\indianonlinetax\\branches\\indiateam\\integration-tests\\dit\\sig\\DSC_Sweta.pfx");
        String dscPassword="112233";
        signerUtil.signFile(xmlFile,dscFile,dscPassword);
        System.out.println("certChain: "+signerUtil.getCertChain());
        System.out.println("Signature: "+signerUtil.getSignature());
        
    }

   
    
}
