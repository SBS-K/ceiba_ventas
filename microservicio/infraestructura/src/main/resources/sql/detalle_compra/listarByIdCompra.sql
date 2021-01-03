SELECT detalle_compra.id, detalle_compra.articulo_id, detalle_compra.cantidad, detalle_compra.subtotal,
articulo.nombre, articulo.descripcion, articulo.precio from detalle_compra
JOIN articulo on articulo.id = detalle_compra.articulo_id
JOIN compra_detalle_compra on compra_detalle_compra.detalle_compra_id = detalle_compra.id
JOIN compra on compra.id = compra_detalle_compra.compra_id
WHERE compra.id = :compraId;