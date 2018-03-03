package guru.springfamework.api.v1.mapper;

import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.domain.Customer;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerMapperTest {

    private CustomerMapper customerMapper;

    @Before
    public void setUp(){
        customerMapper = CustomerMapper.INSTANCE;
    }

    @Test
    public void customerToCustomerDTOTest(){
        Customer customer = new Customer();
        customer.setLastname("Nowak");
        customer.setFirstname("Ala");

        CustomerDTO customerDTO = customerMapper.customerToCustomerDTO(customer);

        assertEquals(customer.getFirstname(),customerDTO.getFirstname());
        assertEquals(customerDTO.getLastname(), customer.getLastname());
    }

    @Test
    public void customerDTOToCustomertest(){

    }
}