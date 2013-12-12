package ETM.ITD.FilingService;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author 459618
 */
public class SignerUtil {
    
    private String certChain = "";
    private String signature = "";
        
    private PrivateKey mPrivateKey;
    private Certificate[] mCertificationChain;
    
    public SignerUtil(){
    }
    
    public void signFile(InputStream fileName,InputStream keyStoreFile,String password)throws Exception{
      
       BufferedInputStream bis=new BufferedInputStream(fileName);
       byte dataByte[]=new byte[bis.available()];
       bis.read(dataByte);
       bis.close();
       
       KeyStore userKeyStore=loadKeyStoreFromPFXFile(keyStoreFile, password);
       setPrivateKeyAndCertChain(userKeyStore, password);
       if (mPrivateKey == null) {
        String errorMessage = "Can not find the private key in the specified file " + ".";
        throw new Exception(errorMessage);
      }

      if (mCertificationChain == null) {
        String errorMessage = "Can not find neither certificate nor certification chain in the file "  + 
          ".";
        throw new Exception(errorMessage);
      }
      certChain=encodeX509CertChainToBase64(mCertificationChain);
      X509Certificate x509Certificate=getX509Certificate(certChain);
      byte[] digitalSignature = signDocument(dataByte, mPrivateKey, x509Certificate.getSigAlgName());
      signature= Base64Utils.base64Encode(digitalSignature);
       
       
    }
    
    private KeyStore loadKeyStoreFromPFXFile(InputStream keyStoreStream, String aKeyStorePasswd)
            throws GeneralSecurityException, IOException {
        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        char[] password = aKeyStorePasswd.toCharArray();
        keyStore.load(keyStoreStream, password);
        return keyStore;
    }


    private void setPrivateKeyAndCertChain(KeyStore aKeyStore, String aKeyPassword)
            throws GeneralSecurityException {
        char[] password = aKeyPassword.toCharArray();
        Enumeration aliasesEnum = aKeyStore.aliases();
        if (aliasesEnum.hasMoreElements()) {
            String alias = (String) aliasesEnum.nextElement();
            Certificate[] certificationChain = aKeyStore.getCertificateChain(alias);
            PrivateKey privateKey = (PrivateKey) aKeyStore.getKey(alias, password);

            mPrivateKey = privateKey;
            mCertificationChain = certificationChain;

        }

    }

    private String encodeX509CertChainToBase64(Certificate[] aCertificationChain)
            throws CertificateException {
        List certList = Arrays.asList(aCertificationChain);
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        CertPath certPath = certFactory.generateCertPath(certList);
        byte[] certPathEncoded = certPath.getEncoded("PkiPath");
        String base64encodedCertChain = Base64Utils.base64Encode(certPathEncoded);
        return base64encodedCertChain;
    }

    public X509Certificate getX509Certificate(String strMCertChainBase64encoding) throws  Exception{
        CertPath certPath = null;
        byte[] certChainEncoded = Base64Utils.base64Decode(strMCertChainBase64encoding);
        ByteArrayInputStream certChainStream = new ByteArrayInputStream(certChainEncoded);
        try {
            CertificateFactory cf = CertificateFactory.getInstance("X.509");
            certPath = cf.generateCertPath(certChainStream, "PkiPath");
            List certsInChain = certPath.getCertificates();
            X509Certificate[] mCertChain = (X509Certificate[]) certsInChain.toArray(new X509Certificate[0]);
            X509Certificate mCertificate = mCertChain[0];

            X509Certificate localX509Certificate1 = mCertificate;
            return localX509Certificate1;
        } finally {
                certChainStream.close();
        }
    }

    private byte[] signDocument(byte[] aDocument, PrivateKey aPrivateKey, String Algorithm)
            throws GeneralSecurityException {
        System.out.println("2nd Sign");
        Signature signatureAlgorithm = Signature.getInstance(Algorithm);
        signatureAlgorithm.initSign(aPrivateKey);
        signatureAlgorithm.update(aDocument);
        byte[] digitalSignature = signatureAlgorithm.sign();
        return digitalSignature;
    }

    public String getCertChain() {
        return certChain;
    }

    public void setCertChain(String certChain) {
        this.certChain = certChain;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }
    

}

