package com.wait;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.bind.annotation.XmlSeeAlso;

/**
 * This class was generated by Apache CXF 3.0.2
 * 2016-03-24T11:30:50.923+01:00
 * Generated source version: 3.0.2
 * 
 */
@WebService(targetNamespace = "http://wait.com/", name = "CustomerOrdersPortType")
@XmlSeeAlso({ObjectFactory.class})
@SOAPBinding(parameterStyle = SOAPBinding.ParameterStyle.BARE)
public interface CustomerOrdersPortType {

    @WebMethod
    @WebResult(name = "deleteOrdersResponse", targetNamespace = "http://wait.com/", partName = "parameters")
    public DeleteOrdersResponse deleteOrders(
        @WebParam(partName = "parameters", name = "deleteOrdersRequest", targetNamespace = "http://wait.com/")
        DeleteOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "getOrdersResponse", targetNamespace = "http://wait.com/", partName = "parameters")
    public GetOrdersResponse getOrders(
        @WebParam(partName = "parameters", name = "getOrdersRequest", targetNamespace = "http://wait.com/")
        GetOrdersRequest parameters
    );

    @WebMethod
    @WebResult(name = "createOrdersResponse", targetNamespace = "http://wait.com/", partName = "parameters")
    public CreateOrdersResponse createOrders(
        @WebParam(partName = "parameters", name = "createOrdersRequest", targetNamespace = "http://wait.com/")
        CreateOrdersRequest parameters
    );
}
