package com.example.springboot.service;

public class TestCasesForM {

    @Test
    public void ssnValidAndCustomerBlocked() throws ServiceException {
        Long vlaPk = 123L;
        CarLot carLot = new CarLot();
        carLot.setPk(vlaPk);
        carLot.setTestCarLot("N");
        //   when(step1Bean.isSsnValid(carLot, false, anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), anyString(), true)).thenReturn(true);
        step1Bean.setSsnBlockedCustomer(true);
        when(step1Bean.getSystemVariablesService().getBooleanValue(Matchers.<SystemVariableType>anyObject())).thenReturn(true);
        step1Bean.checkCustomerSsnValidAndSsnoptCustomerBlocked(carLot, "999", "89", "0000", "fname", "lname", "city", "MI", "12345", true,
                false, true, formErrors);

        assertEquals("blockedapplicant", formErrors.getErrors("ssn").get(0).getMessageKey());
    }
}
