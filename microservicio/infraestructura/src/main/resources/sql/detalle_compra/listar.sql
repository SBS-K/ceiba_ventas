SELECT detalle_compra.id, detalle_compra.articulo_id, detalle_compra.cantidad, detalle_compra.subtotal,
articulo.nombre, articulo.descripcion, articulo.precio from detalle_compra
JOIN articulo on articulo.id = detalle_compra.articulo_id;