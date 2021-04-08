package com.example.springboot.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class Venta {
    private Integer idVenta;
    private LocalDateTime fecha;

    public Venta(Integer idVenta, LocalDateTime fecha) {
        this.idVenta = idVenta;
        this.fecha = fecha;
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Venta venta = (Venta) o;
        return Objects.equals(idVenta, venta.idVenta) &&
                Objects.equals(fecha, venta.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idVenta, fecha);
    }

    @Override
    public String toString() {
        return "Venta{" +
                "idVenta=" + idVenta +
                ", fecha=" + fecha +
                '}';
    }
}
