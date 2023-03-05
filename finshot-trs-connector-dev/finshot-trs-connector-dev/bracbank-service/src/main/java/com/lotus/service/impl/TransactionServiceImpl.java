package com.lotus.service.impl;

import com.lotus.entity.InformationTransaction;
import com.lotus.repository.ITransactionRepository;
import com.lotus.service.ITransactionService;
import com.lotus.model.request.BaseRequest;
import com.lotus.model.request.TransOrder;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.www.http.HttpClient;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.security.*;
import java.security.cert.Certificate;
import java.util.Base64;
import java.util.Calendar;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private ITransactionRepository transactionRepo;

    @Override
    public InformationTransaction addTransactionInfo(TransOrder transOrder) throws IOException {
        transOrder.getBaseReq().setEnteredDatetime(Calendar.getInstance().getTime());
        createSign(transOrder);
        send(transOrder);

        InformationTransaction info = new InformationTransaction();
        info.setUserName(transOrder.getBaseReq().getUserName());
        info.setExPassword(transOrder.getBaseReq().getExPassword());
        info.setExCode(transOrder.getBaseReq().getExCode());
        info.setEnteredDatetime(transOrder.getBaseReq().getEnteredDatetime());

        info.setTranNo(transOrder.getTransactionReq().getTranNo());
        info.setTranInfoSl(transOrder.getTransactionReq().getTranInfoSl());
        info.setTrMode(transOrder.getTransactionReq().getTrMode());
        info.setPurose(transOrder.getTransactionReq().getPurose());
        info.setRemAmountSource(transOrder.getTransactionReq().getRemAmountSource());
        info.setRemAmountDest(transOrder.getTransactionReq().getRemAmountDest());
        info.setIncentiveAmount(transOrder.getTransactionReq().getIncentiveAmount());
        info.setIncentiveAmountAgr(transOrder.getTransactionReq().getIncentiveAmountAgr());
        info.setRateValue(transOrder.getTransactionReq().getRateValue());
        info.setRemId(transOrder.getTransactionReq().getRemId());
        info.setRemFname(transOrder.getTransactionReq().getRemFname());
        info.setRemLname(transOrder.getTransactionReq().getRemLname());
        info.setRemTel(transOrder.getTransactionReq().getRemTel());
        info.setRemAddress1(transOrder.getTransactionReq().getRemAddress1());
        info.setRemCountry(transOrder.getTransactionReq().getRemCountry());
        info.setBeneficiAryId(transOrder.getTransactionReq().getBeneficiAryId());
        info.setBeneName(transOrder.getTransactionReq().getBeneName());
        info.setBeneMname(transOrder.getTransactionReq().getBeneMname());
        info.setBeneLname(transOrder.getTransactionReq().getBeneLname());
        info.setBeneAccountNo(transOrder.getTransactionReq().getBeneAccountNo());
        info.setBeneTel(transOrder.getTransactionReq().getBeneTel());
        info.setBranchCode(transOrder.getTransactionReq().getBranchCode());
        info.setBeneftnCode(transOrder.getTransactionReq().getBeneftnCode());
        info.setBeneAddress(transOrder.getTransactionReq().getBeneAddress());
        info.setBeneCountry(transOrder.getTransactionReq().getBeneCountry());
        info.setSignatureValue(transOrder.getTransactionReq().getSignaturevalue());
        info.setCountTr(transOrder.getTransactionReq().getCountTr());
        info.setTranStatus(transOrder.getTransactionReq().getTranStatus());

        transactionRepo.save(info);
        return info;

    }

    @Override
    public BaseRequest checkStatus(TransOrder transOrder) throws IOException {
        String tranXML = convertObjectToXML(transOrder);

        HttpGet httpRequest = new HttpGet("https://fex.bracbank.org/remapiuat/getxmltraninfobyiduat/AR201000007150");
//        httpRequest.setEntity(new StringEntity(tranXML));
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse httpResponse = httpclient.execute(httpRequest, new BasicHttpContext());

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // handle response ok
            return new BaseRequest("200", "success", httpResponse);
        }else {
            // handle error
            return new BaseRequest("404", "error", httpResponse);
        }
    }

    public static String convertObjectToXML(TransOrder transactionInfo) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(InformationTransaction.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(transactionInfo, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return xmlString;


    }

    @Override
    public List<InformationTransaction> search() {
        return transactionRepo.findAll();
    }

    public static String convertObjectToXML(InformationTransaction transInfo) {
        String xmlString = "";
        try {
            JAXBContext context = JAXBContext.newInstance(InformationTransaction.class);
            Marshaller m = context.createMarshaller();

            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            StringWriter sw = new StringWriter();
            m.marshal(transInfo, sw);
            xmlString = sw.toString();

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return xmlString;
    }


    // call API Transaction
    public BaseRequest send(TransOrder TrnOrder) throws IOException {
        String tranXML = convertObjectToXML(TrnOrder);

        HttpPost httpRequest = new HttpPost("https://fex.bracbank.org/remapiuat/***method");
        httpRequest.setEntity(new StringEntity(tranXML));

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse httpResponse = httpclient.execute(httpRequest, new BasicHttpContext());

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // handle response ok
            return new BaseRequest("200", "success", httpResponse);
        }else {
            // handle error
            return new BaseRequest("404", "error", httpResponse);
        }
    }

    public BaseRequest validateAccount(TransOrder transactionInfo) throws IOException {
        String tranXML = convertObjectToXML(transactionInfo);

        HttpPost httpRequest = new HttpPost("https://fex.bracbank.org/remapiuat/t24validation");
        httpRequest.setEntity(new StringEntity(tranXML));

        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse httpResponse = httpclient.execute(httpRequest, new BasicHttpContext());

        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // handle response ok
            return new BaseRequest("200", "success", httpResponse);
        }else {
            // handle error
            return new BaseRequest("404", "error", httpResponse);
        }
    }

    public BaseRequest validateMremit(TransOrder trnOrder) throws IOException {
        String tranXML = convertObjectToXML(trnOrder);

        HttpPost httpRequest = new HttpPost("https://fex.bracbank.org/remapiuat/bkashvalidation");
        httpRequest.setEntity(new StringEntity(tranXML));

        HttpClient httpClient = new DefaultHttpClient();
        HttpResponse httpResponse = httpClient.execute(httpRequest, new BasicHttpContext());
        if (httpResponse.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            // handle response ok
            return new BaseRequest("200", "success", httpResponse);
        }else {
            // handle error
            return new BaseRequest("404", "error", httpResponse);;
        }
    }

    public void createSign(TransOrder info){
        String traninfostr = "";

        traninfostr = info.getTransactionReq().getTranNo() + info.getTransactionReq().getTrMode() + info.getTransactionReq().getBeneName() +
                info.getTransactionReq().getRemFname() + info.getTransactionReq().getBeneAccountNo() + info.getTransactionReq().getBranchCode() +
                info.getTransactionReq().getBeneTel() + info.getTransactionReq().getRemAmountDest().toString() + info.getBaseReq().getEnteredDatetime().toString();
        System.out.println("Signing: " + traninfostr);
//        String signval = "";
//
//        try {
//            KeyStore keystore = KeyStore.getInstance("pkcs12", "SunJSSE");
//            char[] password = "abl-2017".toCharArray();
//            keystore.load(new FileInputStream("/opt/ABL4006.pfx"), password);
//            KeyPair key = getKeyPair(keystore, "te-1dfdb065-f932-406d-b48d-72a9d2ccba55", password);
//
//            signval = sign(traninfostr, key.getPrivate());
//        } catch (Exception e) {
//            System.err.println("Signing error: " + e.getMessage());
//            e.printStackTrace();
//        }
        info.getTransactionReq().setSignaturevalue(traninfostr);
//        info.setSignatureValue(signval);
        convertObjectToXML(info);
    }

    public static KeyPair getKeyPair(KeyStore keystore, String alias, char[] password) {
        try {
            // Get private key
            Key key = keystore.getKey(alias, password);
            if (key instanceof PrivateKey) {
                // Get certificate of public key
                Certificate cert = keystore.getCertificate(alias);
                // Get public key
                PublicKey publicKey = cert.getPublicKey();
                // Return a key pair
                return new KeyPair(publicKey, (PrivateKey) key);
            }
        } catch (UnrecoverableKeyException e) {
        } catch (NoSuchAlgorithmException e) {
        } catch (KeyStoreException e) {
            System.err.println("key error: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public static String sign(String plainText, PrivateKey privateKey) throws Exception {
        Signature privateSignature = Signature.getInstance("SHA1withRSA");
        privateSignature.initSign(privateKey);
        privateSignature.update(plainText.getBytes(UTF_8));
        byte[] signature = privateSignature.sign();
        return Base64.getEncoder().encodeToString(signature);
    }
}
