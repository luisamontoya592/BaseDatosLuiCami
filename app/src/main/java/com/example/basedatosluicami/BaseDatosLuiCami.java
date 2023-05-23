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
                "NombreCliente text, DireccionCliente text, TelefonoCliente text)");

        dataBase.execSQL("create table Producto(IdProducto int primary key, " +
                "NombreProducto text, ValorProducto float, FabricanteProducto text)");

        dataBase.execSQL("create table Pedido(IdPedido int primary key, " +
                "IdCliente int, DescripcionPedido text, FechaPedido text, " +
                "Foreign key (IdCliente) references Cliente(IdCliente) ON DELETE CASCADE ON UPDATE CASCADE)");

        dataBase.execSQL("create table Factura(IdFactura int primary key autoincrement, " +
                "IdCliente int, IdProducto int, IdPedido int,ValorFactura real, FechaFactura text," +
                "Foreign key (IdCliente) references Cliente(IdCliente) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "Foreign key (IdProducto) references Producto(IdProducto)ON DELETE CASCADE ON UPDATE CASCADE," +
                "Foreign key (IdPedido) references Pedido(IdPedido) ON DELETE CASCADE ON UPDATE CASCADE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase dataBase, int version, int newVersion) {

        dataBase.execSQL("drop table if exists Cliente");
        dataBase.execSQL("create table Cliente(IdCliente int primary key, " +
                "NombreCliente text, DireccionCliente text, TelefonoCliente text)");


        dataBase.execSQL("drop table if exists Producto");
        dataBase.execSQL("create table Producto(IdProducto int primary key, " +
                "NombreProducto text, ValorProducto float, FabricanteProducto text)");


        dataBase.execSQL("drop table if exists Pedido");
        dataBase.execSQL("create table Pedido(IdPedido int primary key, " +
                "IdCliente int, DescripcionPedido text, FechaPedido text, " +
                "Foreign key (IdCliente) references Cliente(IdCliente) ON DELETE CASCADE ON UPDATE CASCADE)");


        dataBase.execSQL("drop table if exists Factura");
        dataBase.execSQL("create table Factura(IdFactura int primary key autoincrement, " +
                "IdCliente int, IdProducto int, IdPedido int,ValorFactura real, FechaFactura text," +
                "Foreign key (IdCliente) references Cliente(IdCliente) ON DELETE CASCADE ON UPDATE CASCADE, " +
                "Foreign key (IdProducto) references Producto(IdProducto)ON DELETE CASCADE ON UPDATE CASCADE," +
                "Foreign key (IdPedido) references Pedido(IdPedido) ON DELETE CASCADE ON UPDATE CASCADE)");

    }
}
