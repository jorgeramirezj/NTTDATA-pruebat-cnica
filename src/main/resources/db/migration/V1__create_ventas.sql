CREATE TABLE ventas
(
    id_venta          BIGSERIAL PRIMARY KEY,
    id_empleado       BIGINT         NOT NULL,
    descripcion_venta VARCHAR(200),
    valor_venta       NUMERIC(14, 2) NOT NULL
);
