<?xml version="1.0" encoding="UTF-8"?>
<model ref="r:8a1101ed-962a-4696-a62f-4c748027cca5(SampleSolution.Lecture)">
  <persistence version="9" />
  <languages>
    <use id="9859e7a1-4876-4909-a664-8a214c206698" name="MetaModel" version="0" />
  </languages>
  <imports />
  <registry>
    <language id="9859e7a1-4876-4909-a664-8a214c206698" name="MetaModel">
      <concept id="1342586541813388693" name="MetaModel.structure.Bidirectional" flags="ng" index="2zC0rd">
        <property id="1342586541813388710" name="domainEndSpecification" index="2zC0rY" />
        <child id="1342586541813388712" name="connector" index="2zC0rK" />
      </concept>
      <concept id="1342586541813396118" name="MetaModel.structure.ConstrainedTargetConnector" flags="ng" index="2zC27e">
        <property id="1342586541813396133" name="constraint" index="2zC27X" />
      </concept>
      <concept id="1342586541813382694" name="MetaModel.structure.OwnerConnector" flags="ng" index="2zC6PY">
        <reference id="1342586541813382695" name="ownerType" index="2zC6PZ" />
      </concept>
      <concept id="6576532306767764478" name="MetaModel.structure.AttributeConnector" flags="ng" index="2_wlaR" />
      <concept id="1967123554055742618" name="MetaModel.structure.TypeAdapter" flags="ng" index="BxOjD">
        <reference id="1967123554055742621" name="type" index="BxOjI" />
      </concept>
      <concept id="3845874433725122187" name="MetaModel.structure.Unidirectional" flags="ng" index="3_FwNw">
        <reference id="3845874433725122188" name="ownerType" index="3_FwNB" />
      </concept>
      <concept id="3845874433725109376" name="MetaModel.structure.Generalisation" flags="ng" index="3_F_VF">
        <reference id="3845874433725109379" name="specific" index="3_F_VC" />
        <reference id="3845874433725109377" name="general" index="3_F_VE" />
      </concept>
      <concept id="3845874433725116463" name="MetaModel.structure.TargetConnector" flags="ng" index="3_FBD4">
        <reference id="3845874433725116464" name="targetType" index="3_FBDr" />
      </concept>
      <concept id="3845874433725116460" name="MetaModel.structure.Connector" flags="ng" index="3_FBD7">
        <property id="3845874433725116461" name="role" index="3_FBD6" />
      </concept>
      <concept id="3845874433725116455" name="MetaModel.structure.Association" flags="ng" index="3_FBDc">
        <child id="3845874433725125412" name="target" index="3_Fx_f" />
        <child id="3845874433725125405" name="owner" index="3_Fx_Q" />
      </concept>
      <concept id="3845874433725012817" name="MetaModel.structure.Service" flags="ng" index="3_Gd4U">
        <child id="6576532306767764468" name="operations" index="2_wlaX" />
        <child id="3845874433725111961" name="generalisations" index="3_F_jM" />
        <child id="3845874433725012820" name="relationTypes" index="3_Gd4Z" />
      </concept>
      <concept id="3845874433725012776" name="MetaModel.structure.PrimitiveType" flags="ng" index="3_Gd53" />
      <concept id="3845874433725012781" name="MetaModel.structure.Class" flags="ng" index="3_Gd56">
        <property id="3845874433725012782" name="singleton" index="3_Gd55" />
        <child id="6576532306767764487" name="attributes" index="2_wlle" />
        <child id="3845874433725012801" name="operations" index="3_Gd4E" />
      </concept>
      <concept id="3845874433725012784" name="MetaModel.structure.Operation" flags="ng" index="3_Gd5r">
        <property id="3845874433725012785" name="techName" index="3_Gd5q" />
        <child id="1967123554056188092" name="returnType" index="BBx3f" />
        <child id="3845874433725021043" name="formalParameters" index="3_Gf4o" />
      </concept>
      <concept id="3845874433725021038" name="MetaModel.structure.Parameter" flags="ng" index="3_Gf45">
        <child id="1967123554056188103" name="type" index="BBx2O" />
      </concept>
    </language>
    <language id="ceab5195-25ea-4f22-9b92-103b95ca8c0c" name="jetbrains.mps.lang.core">
      <concept id="1169194658468" name="jetbrains.mps.lang.core.structure.INamedConcept" flags="ng" index="TrEIO">
        <property id="1169194664001" name="name" index="TrG5h" />
      </concept>
    </language>
  </registry>
  <node concept="3_Gd4U" id="5H4ykBYMXjP">
    <property role="TrG5h" value="baseTypes" />
    <node concept="3_Gd53" id="5H4ykBYMXjQ" role="3_Gd4Z">
      <property role="TrG5h" value="String" />
    </node>
    <node concept="3_Gd53" id="5H4ykBYMXjV" role="3_Gd4Z">
      <property role="TrG5h" value="Integer" />
    </node>
    <node concept="3_Gd53" id="5H4ykBYMXk3" role="3_Gd4Z">
      <property role="TrG5h" value="Rational" />
    </node>
    <node concept="3_Gd53" id="5H4ykBYMXkd" role="3_Gd4Z">
      <property role="TrG5h" value="Boolean" />
    </node>
  </node>
  <node concept="3_Gd4U" id="1MdcxidCjBV">
    <property role="TrG5h" value="CinemaService" />
    <node concept="3_Gd5r" id="1MdcxidCku6" role="2_wlaX">
      <property role="3_Gd5q" value="register" />
      <node concept="3_Gf45" id="1MdcxidCkuh" role="3_Gf4o">
        <property role="TrG5h" value="name" />
        <node concept="BxOjD" id="1MdcxidCkxQ" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="3_Gf45" id="1MdcxidCkxT" role="3_Gf4o">
        <property role="TrG5h" value="password" />
        <node concept="BxOjD" id="1MdcxidCkxZ" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="BxOjD" id="1MdcxidCkxO" role="BBx3f">
        <ref role="BxOjI" node="1MdcxidCjCK" resolve="User" />
      </node>
    </node>
    <node concept="3_Gd5r" id="1MdcxidCky2" role="2_wlaX">
      <property role="3_Gd5q" value="register" />
      <node concept="3_Gf45" id="1MdcxidCkyx" role="3_Gf4o">
        <property role="TrG5h" value="name" />
        <node concept="BxOjD" id="1MdcxidCky_" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="3_Gf45" id="1MdcxidCkyC" role="3_Gf4o">
        <property role="TrG5h" value="password" />
        <node concept="BxOjD" id="1MdcxidCkyI" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="3_Gf45" id="1MdcxidCkyL" role="3_Gf4o">
        <property role="TrG5h" value="role" />
        <node concept="BxOjD" id="1MdcxidCkyT" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjE9" resolve="Role" />
        </node>
      </node>
      <node concept="BxOjD" id="1MdcxidCkyW" role="BBx3f">
        <ref role="BxOjI" node="1MdcxidCjCK" resolve="User" />
      </node>
    </node>
    <node concept="3_Gd5r" id="1MdcxidCkuo" role="2_wlaX">
      <property role="3_Gd5q" value="unregister" />
      <node concept="3_Gf45" id="1MdcxidCkuA" role="3_Gf4o">
        <property role="TrG5h" value="user" />
        <node concept="BxOjD" id="1MdcxidCkuE" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjCK" resolve="User" />
        </node>
      </node>
    </node>
    <node concept="3_Gd5r" id="1MdcxidCkuH" role="2_wlaX">
      <property role="3_Gd5q" value="addHall" />
      <node concept="3_Gf45" id="1MdcxidCkuY" role="3_Gf4o">
        <property role="TrG5h" value="name" />
        <node concept="BxOjD" id="1MdcxidCkyY" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="BxOjD" id="1MdcxidCkz1" role="BBx3f">
        <ref role="BxOjI" node="1MdcxidCjIb" resolve="Hall" />
      </node>
    </node>
    <node concept="3_Gd5r" id="1MdcxidCkv5" role="2_wlaX">
      <property role="3_Gd5q" value="removeHall" />
      <node concept="3_Gf45" id="1MdcxidCkvp" role="3_Gf4o">
        <property role="TrG5h" value="hall" />
        <node concept="BxOjD" id="1MdcxidCkvw" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjIb" resolve="Hall" />
        </node>
      </node>
    </node>
    <node concept="3_Gd5r" id="1MdcxidCkvz" role="2_wlaX">
      <property role="3_Gd5q" value="addFilm" />
      <node concept="3_Gf45" id="1MdcxidCkvU" role="3_Gf4o">
        <property role="TrG5h" value="name" />
        <node concept="BxOjD" id="1MdcxidCkz3" role="BBx2O">
          <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
        </node>
      </node>
      <node concept="BxOjD" id="1MdcxidCk_t" role="BBx3f">
        <ref role="BxOjI" node="1MdcxidCjWL" resolve="Film" />
      </node>
    </node>
    <node concept="3_Gd5r" id="1MdcxidCkw1" role="2_wlaX">
      <property role="3_Gd5q" value="removeFilm" />
      <node concept="3_Gf45" id="1MdcxidCkwr" role="3_Gf4o">
        <property role="TrG5h" value="film" />
        <node concept="BxOjD" id="1MdcxidCk_w" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjWL" resolve="Film" />
        </node>
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjCK" role="3_Gd4Z">
      <property role="TrG5h" value="User" />
      <node concept="2_wlaR" id="1MdcxidCjCM" role="2_wlle">
        <property role="3_FBD6" value="username" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjCO" role="3_Gd4E">
        <property role="3_Gd5q" value="login" />
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjCU" role="3_Gd4E">
        <property role="3_Gd5q" value="logout" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjDr" role="3_Gd4Z">
      <property role="TrG5h" value="Password" />
      <node concept="2_wlaR" id="1MdcxidCjDy" role="2_wlle">
        <property role="3_FBD6" value="password" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="2_wlaR" id="1MdcxidCjD$" role="2_wlle">
        <property role="3_FBD6" value="salt" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjDB" role="3_Gd4E">
        <property role="3_Gd5q" value="checkPassword" />
        <node concept="3_Gf45" id="1MdcxidCjDD" role="3_Gf4o">
          <property role="TrG5h" value="pw" />
          <node concept="BxOjD" id="1MdcxidCjDH" role="BBx2O">
            <ref role="BxOjI" node="5H4ykBYMXjQ" resolve="String" />
          </node>
        </node>
        <node concept="BxOjD" id="1MdcxidCjDK" role="BBx3f">
          <ref role="BxOjI" node="5H4ykBYMXkd" resolve="Boolean" />
        </node>
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjE9" role="3_Gd4Z">
      <property role="TrG5h" value="Role" />
    </node>
    <node concept="3_Gd56" id="1MdcxidCjEB" role="3_Gd4Z">
      <property role="TrG5h" value="Customer" />
      <property role="3_Gd55" value="true" />
    </node>
    <node concept="3_Gd56" id="1MdcxidCjFh" role="3_Gd4Z">
      <property role="TrG5h" value="Owner" />
      <property role="3_Gd55" value="true" />
    </node>
    <node concept="3_Gd56" id="1MdcxidCjFL" role="3_Gd4Z">
      <property role="TrG5h" value="Reservation" />
      <node concept="3_Gd5r" id="1MdcxidCjGs" role="3_Gd4E">
        <property role="3_Gd5q" value="book" />
        <node concept="BxOjD" id="1MdcxidCk_h" role="BBx3f">
          <ref role="BxOjI" node="1MdcxidCk8y" resolve="Booking" />
        </node>
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjGp" role="3_Gd4E">
        <property role="3_Gd5q" value="cancel" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCk8y" role="3_Gd4Z">
      <property role="TrG5h" value="Booking" />
      <node concept="3_Gd5r" id="1MdcxidCk9F" role="3_Gd4E">
        <property role="3_Gd5q" value="cancel" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjGD" role="3_Gd4Z">
      <property role="TrG5h" value="Mitte" />
      <node concept="3_Gd5r" id="1MdcxidCjGZ" role="3_Gd4E">
        <property role="3_Gd5q" value="stornieren" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjHo" role="3_Gd4Z">
      <property role="TrG5h" value="Show" />
      <node concept="2_wlaR" id="1MdcxidCjHK" role="2_wlle">
        <property role="3_FBD6" value="reservable" />
        <ref role="3_FBDr" node="5H4ykBYMXkd" resolve="Boolean" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjWL" role="3_Gd4Z">
      <property role="TrG5h" value="Film" />
      <node concept="2_wlaR" id="1MdcxidCjXE" role="2_wlle">
        <property role="3_FBD6" value="name" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjIb" role="3_Gd4Z">
      <property role="TrG5h" value="Hall" />
      <node concept="2_wlaR" id="1MdcxidCjI_" role="2_wlle">
        <property role="3_FBD6" value="name" />
        <ref role="3_FBDr" node="5H4ykBYMXjQ" resolve="String" />
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjIB" role="3_Gd4E">
        <property role="3_Gd5q" value="addShow" />
        <node concept="BxOjD" id="1MdcxidCk_5" role="BBx3f">
          <ref role="BxOjI" node="1MdcxidCjUn" resolve="Back" />
        </node>
        <node concept="3_Gf45" id="1MdcxidCk_j" role="3_Gf4o">
          <property role="TrG5h" value="film" />
          <node concept="BxOjD" id="1MdcxidCk_z" role="BBx2O">
            <ref role="BxOjI" node="1MdcxidCjWL" resolve="Film" />
          </node>
        </node>
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjJe" role="3_Gd4E">
        <property role="3_Gd5q" value="removeShow" />
        <node concept="3_Gf45" id="1MdcxidCjJO" role="3_Gf4o">
          <property role="TrG5h" value="show" />
          <node concept="BxOjD" id="1MdcxidCjJS" role="BBx2O">
            <ref role="BxOjI" node="1MdcxidCjHo" resolve="Show" />
          </node>
        </node>
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjK3" role="3_Gd4Z">
      <property role="TrG5h" value="SeatingRow" />
      <node concept="2_wlaR" id="1MdcxidCjKF" role="2_wlle">
        <property role="3_FBD6" value="nr" />
        <ref role="3_FBDr" node="5H4ykBYMXjV" resolve="Integer" />
      </node>
      <node concept="3_Gd5r" id="1MdcxidCjKS" role="3_Gd4E">
        <property role="3_Gd5q" value="setCategory" />
        <node concept="3_Gf45" id="1MdcxidCjKY" role="3_Gf4o">
          <property role="TrG5h" value="category" />
          <node concept="BxOjD" id="1MdcxidCjVu" role="BBx2O">
            <ref role="BxOjI" node="1MdcxidCjNx" resolve="Category" />
          </node>
        </node>
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjLS" role="3_Gd4Z">
      <property role="TrG5h" value="Seat" />
      <node concept="2_wlaR" id="1MdcxidCjMF" role="2_wlle">
        <property role="3_FBD6" value="nr" />
        <ref role="3_FBDr" node="5H4ykBYMXjV" resolve="Integer" />
      </node>
    </node>
    <node concept="3_Gd56" id="1MdcxidCjNx" role="3_Gd4Z">
      <property role="TrG5h" value="Category" />
    </node>
    <node concept="3_Gd56" id="1MdcxidCjQV" role="3_Gd4Z">
      <property role="TrG5h" value="Parterre" />
      <property role="3_Gd55" value="true" />
    </node>
    <node concept="3_Gd56" id="1MdcxidCjSD" role="3_Gd4Z">
      <property role="TrG5h" value="Middle" />
      <property role="3_Gd55" value="true" />
    </node>
    <node concept="3_Gd56" id="1MdcxidCjUn" role="3_Gd4Z">
      <property role="TrG5h" value="Back" />
      <property role="3_Gd55" value="true" />
    </node>
    <node concept="3_FBDc" id="1MdcxidCjYA" role="3_Gd4Z">
      <property role="TrG5h" value="User_Has_Password" />
      <node concept="3_FwNw" id="1MdcxidCjZB" role="3_Fx_Q">
        <ref role="3_FwNB" node="1MdcxidCjCK" resolve="User" />
      </node>
      <node concept="2zC27e" id="1MdcxidCjZI" role="3_Fx_f">
        <property role="3_FBD6" value="password" />
        <ref role="3_FBDr" node="1MdcxidCjDr" resolve="Password" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCk0I" role="3_Gd4Z">
      <property role="TrG5h" value="User_Has_Role" />
      <node concept="3_FwNw" id="1MdcxidCk1M" role="3_Fx_Q">
        <ref role="3_FwNB" node="1MdcxidCjCK" resolve="User" />
      </node>
      <node concept="2zC27e" id="1MdcxidCk1P" role="3_Fx_f">
        <property role="3_FBD6" value="role" />
        <ref role="3_FBDr" node="1MdcxidCjE9" resolve="Role" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCk2S" role="3_Gd4Z">
      <property role="TrG5h" value="User_Reservation" />
      <node concept="2zC0rd" id="1MdcxidCk3Z" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmr/Containment" />
        <node concept="2zC6PY" id="1MdcxidCk41" role="2zC0rK">
          <property role="3_FBD6" value="user" />
          <ref role="2zC6PZ" node="1MdcxidCjCK" resolve="User" />
        </node>
      </node>
      <node concept="2zC27e" id="1MdcxidCk45" role="3_Fx_f">
        <property role="3_FBD6" value="reservations" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="1MdcxidCjFL" resolve="Reservation" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCk5c" role="3_Gd4Z">
      <property role="TrG5h" value="Booking_For_Reservation" />
      <node concept="2zC0rd" id="1MdcxidCk6n" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmn/Injective" />
        <node concept="2zC6PY" id="1MdcxidCk6p" role="2zC0rK">
          <property role="3_FBD6" value="booking" />
          <ref role="2zC6PZ" node="1MdcxidCk8y" resolve="Booking" />
        </node>
      </node>
      <node concept="2zC27e" id="1MdcxidCk9P" role="3_Fx_f">
        <property role="3_FBD6" value="for" />
        <ref role="3_FBDr" node="1MdcxidCjFL" resolve="Reservation" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCkb2" role="3_Gd4Z">
      <property role="TrG5h" value="Reservation_Show" />
      <node concept="2zC0rd" id="1MdcxidCkcj" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmr/Containment" />
        <node concept="2zC6PY" id="1MdcxidCkcl" role="2zC0rK">
          <property role="3_FBD6" value="show" />
          <ref role="2zC6PZ" node="1MdcxidCjHo" resolve="Show" />
        </node>
      </node>
      <node concept="2zC27e" id="1MdcxidCkcp" role="3_Fx_f">
        <property role="3_FBD6" value="reservations" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="1MdcxidCjFL" resolve="Reservation" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCkm2" role="3_Gd4Z">
      <property role="TrG5h" value="Reservation_Seat" />
      <node concept="3_FwNw" id="1MdcxidCknx" role="3_Fx_Q">
        <ref role="3_FwNB" node="1MdcxidCjFL" resolve="Reservation" />
      </node>
      <node concept="2zC27e" id="1MdcxidCkn$" role="3_Fx_f">
        <property role="3_FBD6" value="seat" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="1MdcxidCjLS" resolve="Seat" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCkdE" role="3_Gd4Z">
      <property role="TrG5h" value="Show_Hall" />
      <node concept="2zC0rd" id="1MdcxidCkeZ" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmr/Containment" />
        <node concept="2zC6PY" id="1MdcxidCkf1" role="2zC0rK">
          <property role="3_FBD6" value="hall" />
          <ref role="2zC6PZ" node="1MdcxidCjIb" resolve="Hall" />
        </node>
      </node>
      <node concept="2zC27e" id="1MdcxidCkf5" role="3_Fx_f">
        <property role="3_FBD6" value="show" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="1MdcxidCjHo" resolve="Show" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCkgq" role="3_Gd4Z">
      <property role="TrG5h" value="Show_Has_Film" />
      <node concept="3_FwNw" id="1MdcxidCkhN" role="3_Fx_Q">
        <ref role="3_FwNB" node="1MdcxidCjHo" resolve="Show" />
      </node>
      <node concept="2zC27e" id="1MdcxidCkhQ" role="3_Fx_f">
        <property role="3_FBD6" value="film" />
        <ref role="3_FBDr" node="1MdcxidCjWL" resolve="Film" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCkje" role="3_Gd4Z">
      <property role="TrG5h" value="Hall_Row" />
      <node concept="2zC0rd" id="1MdcxidCknB" role="3_Fx_Q">
        <property role="2zC0rY" value="1axOPyL0tmr/Containment" />
        <node concept="2zC6PY" id="1MdcxidCknD" role="2zC0rK">
          <property role="3_FBD6" value="hall" />
          <ref role="2zC6PZ" node="1MdcxidCjIb" resolve="Hall" />
        </node>
      </node>
      <node concept="2zC27e" id="1MdcxidCknH" role="3_Fx_f">
        <property role="3_FBD6" value="rows" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="1MdcxidCjK3" resolve="SeatingRow" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCkpc" role="3_Gd4Z">
      <property role="TrG5h" value="Row_Seat" />
      <node concept="2zC0rd" id="1MdcxidCk_C" role="3_Fx_Q">
        <node concept="2zC6PY" id="1MdcxidCk_E" role="2zC0rK">
          <property role="3_FBD6" value="row" />
          <ref role="2zC6PZ" node="1MdcxidCjK3" resolve="SeatingRow" />
        </node>
      </node>
      <node concept="2zC27e" id="1MdcxidCk_K" role="3_Fx_f">
        <property role="3_FBD6" value="seats" />
        <property role="2zC27X" value="5H4ykBYL_dN/List" />
        <ref role="3_FBDr" node="1MdcxidCjLS" resolve="Seat" />
      </node>
    </node>
    <node concept="3_FBDc" id="1MdcxidCksr" role="3_Gd4Z">
      <property role="TrG5h" value="Row_Has_Category" />
      <node concept="3_FwNw" id="1MdcxidCku0" role="3_Fx_Q">
        <ref role="3_FwNB" node="1MdcxidCjK3" resolve="SeatingRow" />
      </node>
      <node concept="2zC27e" id="1MdcxidCku3" role="3_Fx_f">
        <property role="3_FBD6" value="category" />
        <ref role="3_FBDr" node="1MdcxidCjNx" resolve="Category" />
      </node>
    </node>
    <node concept="3_F_VF" id="1MdcxidCjE_" role="3_F_jM">
      <ref role="3_F_VE" node="1MdcxidCjE9" resolve="Role" />
      <ref role="3_F_VC" node="1MdcxidCjEB" resolve="Customer" />
    </node>
    <node concept="3_F_VF" id="1MdcxidCjG2" role="3_F_jM">
      <ref role="3_F_VE" node="1MdcxidCjE9" resolve="Role" />
      <ref role="3_F_VC" node="1MdcxidCjFh" resolve="Owner" />
    </node>
    <node concept="3_F_VF" id="1MdcxidCjVf" role="3_F_jM">
      <ref role="3_F_VE" node="1MdcxidCjNx" resolve="Category" />
      <ref role="3_F_VC" node="1MdcxidCjQV" resolve="Parterre" />
    </node>
    <node concept="3_F_VF" id="1MdcxidCjVj" role="3_F_jM">
      <ref role="3_F_VE" node="1MdcxidCjNx" resolve="Category" />
      <ref role="3_F_VC" node="1MdcxidCjSD" resolve="Middle" />
    </node>
    <node concept="3_F_VF" id="1MdcxidCjVo" role="3_F_jM">
      <ref role="3_F_VE" node="1MdcxidCjNx" resolve="Category" />
      <ref role="3_F_VC" node="1MdcxidCjUn" resolve="Back" />
    </node>
    <node concept="3_Gd5r" id="1MdcxidCk6t" role="2_wlaX">
      <property role="3_Gd5q" value="reserve" />
      <node concept="3_Gf45" id="1MdcxidCk6v" role="3_Gf4o">
        <property role="TrG5h" value="user" />
        <node concept="BxOjD" id="1MdcxidCk6z" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjCK" resolve="User" />
        </node>
      </node>
      <node concept="3_Gf45" id="1MdcxidCk6A" role="3_Gf4o">
        <property role="TrG5h" value="seat" />
        <node concept="BxOjD" id="1MdcxidCk6G" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjLS" resolve="Seat" />
        </node>
      </node>
      <node concept="3_Gf45" id="1MdcxidCk6J" role="3_Gf4o">
        <property role="TrG5h" value="show" />
        <node concept="BxOjD" id="1MdcxidCk6R" role="BBx2O">
          <ref role="BxOjI" node="1MdcxidCjHo" resolve="Show" />
        </node>
      </node>
      <node concept="BxOjD" id="1MdcxidCk6U" role="BBx3f">
        <ref role="BxOjI" node="1MdcxidCjFL" resolve="Reservation" />
      </node>
    </node>
  </node>
</model>

