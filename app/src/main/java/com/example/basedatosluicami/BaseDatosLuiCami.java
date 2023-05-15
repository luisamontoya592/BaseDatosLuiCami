package com.example.basedatosluicami;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class BaseDatosLuiCami extends SQLiteOpenHelper {

    public static String name = "dataBase";
    public static int version  = 1;
    public BaseDatosLuiCami(@Nullable Context context, @Nullable SQLiteDatabase.CursorFactory factory) {

        super(context, name, factory, version );
    }

    @Override
    public void onCreate(SQLiteDatabase dataBase) {

        dataBase.execSQL("create table Cliente(IdCliente int primary key, " +
                "IdPedido int,IdFactura int,NombreCliente text, DireccionCliente text, TelefonoCliente text," +
                "Foreign key (IdPedido) references Pedido(IdPedido) ON DELETE CASCADE ON UPDATE CASCADE," +
                "Foreign key (IdFactura) references Factura(IdFactura) ON DELETE CASCADE ON UPDATE CASCADE)");

        dataBase.execSQL("create table Producto(IdProducto int primary key, " +
                "NombreProducto text, ValorProducto float, FabricanteProducto text)");

        dataBase.execSQL("create table Pedido(IdPedido int primary key, " +
                "IdCliente int, IdProducto int, IdFactura int,CantidadPedido int, ValorPedido float, FechaPedido datetime, " +
                "Foreign key (IdCliente) references Cliente(IdCliente) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "Foreign key (IdProducto) references Producto(IdProducto)ON DELETE CASCADE ON UPDATE CASCADE," +
                "Foreign key (IdFactura) references Factura(IdFactura) ON DELETE CASCADE ON UPDATE CASCADE)");

        dataBase.execSQL("create table Factura(IdFactura int primary key, " +
                "IdPedido int, ValorFactura float, FechaFactura datetime, ObservacionFactura text," +
                "Foreign key (IdPedido) references Pedido(IdPedido)ON DELETE CASCADE ON UPDATE CASCADE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int version, int newVersion) {

        dataBase.execSQL("drop table if exists Cliente");
        dataBase.execSQL("create table Cliente(IdCliente int primary key, " +
                "IdPedido int,IdFactura int,NombreCliente text, DireccionCliente text, TelefonoCliente text," +
                "Foreign key (IdPedido) references Pedido(IdPedido) ON DELETE CASCADE ON UPDATE CASCADE," +
                "Foreign key (IdFactura) references Factura(IdFactura) ON DELETE CASCADE ON UPDATE CASCADE)");

        dataBase.execSQL("drop table if exists Producto");
        dataBase.execSQL("create table Producto(IdProducto int primary key, " +
                "NombreProducto text, ValorProducto float, FabricanteProducto text)");

        dataBase.execSQL("drop table if exists Pedido");
        dataBase.execSQL("create table Pedido(IdPedido int primary key, " +
                "IdCliente int, IdProducto int, IdFactura int,CantidadPedido int, ValorPedido float, FechaPedido datetime, " +
                "Foreign key (IdCliente) references Cliente(IdCliente) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "Foreign key (IdProducto) references Producto(IdProducto)ON DELETE CASCADE ON UPDATE CASCADE," +
                "Foreign key (IdFactura) references Factura(IdFactura) ON DELETE CASCADE ON UPDATE CASCADE)");

        dataBase.execSQL("drop table if exists Factura");
        dataBase.execSQL("create table Factura(IdFactura int primary key, " +
                "IdPedido int, ValorFactura float, FechaFactura datetime, ObservacionFactura text," +
                "Foreign key (IdPedido) references Pedido(IdPedido)ON DELETE CASCADE ON UPDATE CASCADE)");

    }
}
