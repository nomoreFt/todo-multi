package com.nomoreft.todoapp.shared.value;

import com.nomoreft.todoapp.shared.domain.ValueObject;

import java.util.Objects;

public class Address extends ValueObject<Address> {

    private final String street;
    private final String city;
    private final String state;
    private final String postalCode;

    public Address(String street, String city, String state, String postalCode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(street, address.street) &&
                Objects.equals(city, address.city) &&
                Objects.equals(state, address.state) &&
                Objects.equals(postalCode, address.postalCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, city, state, postalCode);
    }

    @Override
    public String toString() {
        return street + ", " + city + ", " + state + " " + postalCode;
    }

    @Override
    protected Object[] getEqualityFields() {
        return new Object[] { street, city, state, postalCode };
    }
}