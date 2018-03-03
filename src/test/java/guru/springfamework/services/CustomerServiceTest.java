package guru.springfamework.services;

import guru.springfamework.api.v1.mapper.CustomerMapper;
import guru.springfamework.api.v1.model.CustomerDTO;
import guru.springfamework.api.v1.model.CustomerListDTO;
import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class CustomerServiceTest {

    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);
    }

    @Test
    public void getAllCustomersTest() throws Exception {

        //given
        List<Customer> customersList = new ArrayList<>();
        customersList.add(new Customer());
        customersList.add(new Customer());

        when(customerRepository.findAll()).thenReturn(customersList);

        //when
        List<CustomerDTO> list = customerService.getAllCustomers();

        //then
        assertEquals(2, list.size());
    }

    @Test
    public void getCustomerByFirstNameTest() {

        final String firstName = "Ala";

        //given
        Customer customer = new Customer();
        customer.setFirstname(firstName);

        when(customerRepository.findByFirstname(anyString())).thenReturn(customer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerByFirstName(firstName);

        //then
        assertEquals(customerDTO.getFirstname(), firstName);
    }

    @Test
    public void getCustomerByIdTest() {
        final Long ID = 1L;
        final String FIRSTNAME = "Ala";

        //given
        Customer customer = new Customer();
        customer.setId(ID);
        customer.setFirstname(FIRSTNAME);

        Optional<Customer> optionalCustomer = Optional.of(customer);

        when(customerRepository.findById(ID)).thenReturn(optionalCustomer);

        //when
        CustomerDTO customerDTO = customerService.getCustomerById(ID);

        assertEquals(FIRSTNAME,customerDTO.getFirstname());

    }

    @Test
    public void createTest() {
    }

    @Test
    public void updateTest() {
    }

    @Test
    public void deleteCustomerTest() {
    }
}