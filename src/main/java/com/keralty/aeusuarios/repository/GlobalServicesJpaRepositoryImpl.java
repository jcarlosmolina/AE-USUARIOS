package com.keralty.aeusuarios.repository;

import com.keralty.aeusuarios.exception.SystemException;
import com.keralty.aeusuarios.global.AgentexProductoConstants;
import com.keralty.aeusuarios.global.AsesorConstants;
import com.keralty.aeusuarios.global.Constants;
import com.keralty.aeusuarios.global.FrecuenciaActConstants;
import com.keralty.aeusuarios.global.FuncionarioConstants;
import com.keralty.aeusuarios.global.GlobalServiceConstants;
import com.keralty.aeusuarios.global.ProductosConstants;
import com.keralty.aeusuarios.global.RegionalConstants;
import com.keralty.aeusuarios.global.SucursalConstants;
import com.keralty.aeusuarios.global.TipoIdentificacionConstants;
import com.keralty.aeusuarios.global.UserFunctions;
import com.keralty.aeusuarios.persistence.AgentexProducto;
import com.keralty.aeusuarios.persistence.Asesor;
import com.keralty.aeusuarios.persistence.FrecuenciaAct;
import com.keralty.aeusuarios.persistence.Funcionario;
import com.keralty.aeusuarios.persistence.Productos;
import com.keralty.aeusuarios.persistence.Regional;
import com.keralty.aeusuarios.persistence.Sucursal;
import com.keralty.aeusuarios.persistence.TipoIdentificacion;
import com.keralty.aeusuarios.sqlutils.SQLCount;
import com.keralty.aeusuarios.sqlutils.SQLExists;
import com.keralty.aeusuarios.sqlutils.SQLPopulation;
import com.keralty.aeusuarios.sqlutils.SQLSelect;
import com.keralty.aeusuarios.sqlutils.SQLWhereComparison;
import com.keralty.aeusuarios.sqlutils.SQLWhereConjunction;
import com.keralty.aeusuarios.sqlutils.SQLWhereNegation;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandLiteral;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandNull;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandOVParameter;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathAttribute;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandPathInstance;
import com.keralty.aeusuarios.sqlutils.SQLWhereOperandSubQuery;
import com.keralty.aeusuarios.sqlutils.TypedQueryBuilder;
import com.keralty.aeusuarios.utils.Agent;
import jakarta.inject.Inject;
import java.util.Collection;
import org.springframework.stereotype.Service;

@Service
public class GlobalServicesJpaRepositoryImpl extends AbstractRepository implements GlobalServicesJpaRepository {

    @Inject
    public GlobalServicesJpaRepositoryImpl(Agent agent, UserFunctions userFunctionsSrv) {
        super(agent, userFunctionsSrv);
    }

    // AssocOperator: AssocOperator001
	@Override
    public Collection<Productos> assocOperator001(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        try {
            // FOR ALL Productos WHERE (Productos.Producto = ptpatrNumero) DO Productos.sincronizar(Productos, ptpatrDescripcion, ptpatrCodigoLegal)
            return assocOperator001Range1(tGSINC1PRODUCTOptpatrNumero);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator001, Method: assocOperator001";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Productos> assocOperator001Range1 (Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {

        SQLSelect sql = assocOperator001Range1Query(tGSINC1PRODUCTOptpatrNumero);
        return new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute();
    }


    public SQLPopulation assocOperator001Range1Query (Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", ProductosConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.Producto = ptpatrNumero
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1PRODUCTOptpatrNumero, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator001, Method: assocOperator001Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator002
	@Override
    public Boolean assocOperator002(Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        try {
            // EXIST (Productos) WHERE (Productos.Producto = ptpatrNumero)
            return assocOperator002Range1(tGSINC1PRODUCTOptpatrNumero);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator002, Method: assocOperator002";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator002Range1 (Long tGSINC1PRODUCTOptpatrNumero) throws SystemException {
        SQLExists sql = assocOperator002Range1Query(tGSINC1PRODUCTOptpatrNumero, null);
        return !new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator002Range1Query (Long tGSINC1PRODUCTOptpatrNumero, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.Producto = ptpatrNumero
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSPRODUCTO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1PRODUCTOptpatrNumero, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator002, Method: assocOperator002Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator025
	@Override
    public Collection<Regional> assocOperator025(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        try {
            // FOR ALL Regional WHERE (Regional.Codigo = ptpatrCodigo) DO TGSINC1SUCURSALAUX(Regional, ptpatrCodigoSucursal, ptpatrDescripcion)
            return assocOperator025Range1(tGSINC1SUCURSALptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator025, Method: assocOperator025";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Regional> assocOperator025Range1 (Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator025Range1Query(tGSINC1SUCURSALptpatrCodigo);
        return new TypedQueryBuilder<Regional>(em, Regional.class).build(sql).execute();
    }


    public SQLPopulation assocOperator025Range1Query (Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", RegionalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Regional.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(RegionalConstants.CLASS_NAME + "." + RegionalConstants.ATTR_NAME_REGIONALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1SUCURSALptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator025, Method: assocOperator025Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator026
	@Override
    public Boolean assocOperator026(Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        try {
            // EXIST (Regional) WHERE (Regional.Codigo = ptpatrCodigo)
            return assocOperator026Range1(tGSINC1SUCURSALptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator026, Method: assocOperator026";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator026Range1 (Long tGSINC1SUCURSALptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator026Range1Query(tGSINC1SUCURSALptpatrCodigo, null);
        return !new TypedQueryBuilder<Regional>(em, Regional.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator026Range1Query (Long tGSINC1SUCURSALptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", RegionalConstants.CLASS_NAME, RegionalConstants.CLASS_NAME, null, RegionalConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", RegionalConstants.CLASS_NAME, RegionalConstants.CLASS_NAME, null, RegionalConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Regional.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(RegionalConstants.CLASS_NAME + "." + RegionalConstants.ATTR_NAME_REGIONALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1SUCURSALptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator026, Method: assocOperator026Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator028
	@Override
    public Collection<Sucursal> assocOperator028(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        try {
            // FOR ALL Sucursal WHERE (Sucursal.Codigo = ptpatrCodigo) DO Sucursal.TSINCRONIZAR(Sucursal, ptpatrDescripcion, ptpagrRegional)
            return assocOperator028Range1(tGSINC1SUCURSALAUXptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator028, Method: assocOperator028";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Sucursal> assocOperator028Range1 (Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator028Range1Query(tGSINC1SUCURSALAUXptpatrCodigo);
        return new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute();
    }


    public SQLPopulation assocOperator028Range1Query (Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SucursalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1SUCURSALAUXptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator028, Method: assocOperator028Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator029
	@Override
    public Boolean assocOperator029(Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        try {
            // EXIST (Sucursal) WHERE (Sucursal.Codigo = ptpatrCodigo)
            return assocOperator029Range1(tGSINC1SUCURSALAUXptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator029, Method: assocOperator029";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator029Range1 (Long tGSINC1SUCURSALAUXptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator029Range1Query(tGSINC1SUCURSALAUXptpatrCodigo, null);
        return !new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator029Range1Query (Long tGSINC1SUCURSALAUXptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", SucursalConstants.CLASS_NAME, SucursalConstants.CLASS_NAME, null, SucursalConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", SucursalConstants.CLASS_NAME, SucursalConstants.CLASS_NAME, null, SucursalConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1SUCURSALAUXptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator029, Method: assocOperator029Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator041
	@Override
    public Collection<Sucursal> assocOperator041(Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException {
        try {
            // FOR ALL Sucursal WHERE (Sucursal.Codigo = ptpatrCodigoSucursal) DO TGSINC1ASESORAUX(Sucursal, ptpatrUsuario, ptpatrPrimerNombre, ptpatrSegundoNombre, ptpatrPrimerApellido, ptpatrSegundoApellido, ptpatrEmail, pCodDirector, pTipoIdentificacion, pNumIdentificacion, ptpCanal, ptpCargo, ptpEstado)
            return assocOperator041Range1(tGSINC1ASESORptpatrCodigoSucursal);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator041, Method: assocOperator041";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Sucursal> assocOperator041Range1 (Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException {

        SQLSelect sql = assocOperator041Range1Query(tGSINC1ASESORptpatrCodigoSucursal);
        return new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute();
    }


    public SQLPopulation assocOperator041Range1Query (Long tGSINC1ASESORptpatrCodigoSucursal) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SucursalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = ptpatrCodigoSucursal
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1ASESORptpatrCodigoSucursal, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator041, Method: assocOperator041Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator043
	@Override
    public Collection<Asesor> assocOperator043(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.Usuario = ptpatrUsuario AND Asesor.Manual = false) DO Asesor.TSINCRONIZAR(Asesor, ptpatrPrimerNombre, ptpatrSegundoNombre, ptpatrPrimerApellido, ptpatrSegundoApellido, ptpagrSucursal, pCodDirector, pNumIdentificacion, pTipoIdentificacion, ptpCanal, ptpCargo, ptpEstado)
            return assocOperator043Range1(tGSINC1ASESORAUXptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator043, Method: assocOperator043";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Asesor> assocOperator043Range1 (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator043Range1Query(tGSINC1ASESORAUXptpatrUsuario);
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator043Range1Query (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1ASESORAUXptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Asesor.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator043, Method: assocOperator043Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator044
	@Override
    public Collection<Asesor> assocOperator044(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.Usuario = ptpatrUsuario AND Asesor.Manual = true) DO Asesor.modAsesorAgencia(Asesor, ptpatrUsuario, pCodDirector)
            return assocOperator044Range1(tGSINC1ASESORAUXptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator044, Method: assocOperator044";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Asesor> assocOperator044Range1 (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator044Range1Query(tGSINC1ASESORAUXptpatrUsuario);
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator044Range1Query (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1ASESORAUXptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Asesor.Manual = true
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator044, Method: assocOperator044Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator045
	@Override
    public Boolean assocOperator045(String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.Usuario = ptpatrUsuario)
            return assocOperator045Range1(tGSINC1ASESORAUXptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator045, Method: assocOperator045";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator045Range1 (String tGSINC1ASESORAUXptpatrUsuario) throws SystemException {
        SQLExists sql = assocOperator045Range1Query(tGSINC1ASESORAUXptpatrUsuario, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator045Range1Query (String tGSINC1ASESORAUXptpatrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1ASESORAUXptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator045, Method: assocOperator045Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator062
	@Override
    public Collection<TipoIdentificacion> assocOperator062(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        try {
            // FOR ALL TipoIdentificacion WHERE (TipoIdentificacion.Codigo = ptpatrCodigo) DO TipoIdentificacion.sincronizar(TipoIdentificacion, ptpatrDescripcion, ptpatrNombreCorto)
            return assocOperator062Range1(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator062, Method: assocOperator062";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<TipoIdentificacion> assocOperator062Range1 (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator062Range1Query(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
        return new TypedQueryBuilder<TipoIdentificacion>(em, TipoIdentificacion.class).build(sql).execute();
    }


    public SQLPopulation assocOperator062Range1Query (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", TipoIdentificacionConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TipoIdentificacion.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.CLASS_NAME + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1TIPOIDENTIFICACIONptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator062, Method: assocOperator062Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator063
	@Override
    public Boolean assocOperator063(Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        try {
            // EXIST (TipoIdentificacion) WHERE (TipoIdentificacion.Codigo = ptpatrCodigo)
            return assocOperator063Range1(tGSINC1TIPOIDENTIFICACIONptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator063, Method: assocOperator063";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator063Range1 (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator063Range1Query(tGSINC1TIPOIDENTIFICACIONptpatrCodigo, null);
        return !new TypedQueryBuilder<TipoIdentificacion>(em, TipoIdentificacion.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator063Range1Query (Long tGSINC1TIPOIDENTIFICACIONptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, null, TipoIdentificacionConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", TipoIdentificacionConstants.CLASS_NAME, TipoIdentificacionConstants.CLASS_NAME, null, TipoIdentificacionConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // TipoIdentificacion.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(TipoIdentificacionConstants.CLASS_NAME + "." + TipoIdentificacionConstants.ATTR_NAME_TIPOIDENTIFICACIONCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1TIPOIDENTIFICACIONptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator063, Method: assocOperator063Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator091
	@Override
    public Collection<Sucursal> assocOperator091() throws SystemException {
        try {
            // FOR ALL Sucursal WHERE (Sucursal.Codigo = 0) DO Funcionario.TCREAR(fugetRol(ptpagrRol), ptpatrUsuario, pPrimerNombre, pSegundoNombre, pPrimerApellido, pSegundoApellido, "Q", Sucursal, ptpatrUsuario, pEmail, NULL)
            return assocOperator091Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator091, Method: assocOperator091";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Sucursal> assocOperator091Range1 () throws SystemException {

        SQLSelect sql = assocOperator091Range1Query();
        return new TypedQueryBuilder<Sucursal>(em, Sucursal.class).build(sql).execute();
    }


    public SQLPopulation assocOperator091Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", SucursalConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Sucursal.Codigo = 0
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(SucursalConstants.CLASS_NAME + "." + SucursalConstants.ATTR_NAME_SUCURSALCODIGO, Constants.Type.INT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Long.valueOf(0), Constants.Type.NAT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator091, Method: assocOperator091Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator092
	@Override
    public Collection<Funcionario> assocOperator092(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Funcionario WHERE (Funcionario.UsuarioLDAP = ptpatrUsuario) DO Funcionario.TMODIFICARYROL(Funcionario, pPrimerNombre, pSegundoNombre, pPrimerApellido, pSegundoApellido, fugetRol(ptpagrRol), ptpatrUsuario, pEmail, NULL)
            return assocOperator092Range1(tGVERIFICARUSUARIOptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator092, Method: assocOperator092";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Funcionario> assocOperator092Range1 (String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator092Range1Query(tGVERIFICARUSUARIOptpatrUsuario);
        return new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute();
    }


    public SQLPopulation assocOperator092Range1Query (String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGVERIFICARUSUARIOptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator092, Method: assocOperator092Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator093
	@Override
    public Boolean assocOperator093(String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.UsuarioLDAP = ptpatrUsuario)
            return assocOperator093Range1(tGVERIFICARUSUARIOptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator093, Method: assocOperator093";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator093Range1 (String tGVERIFICARUSUARIOptpatrUsuario) throws SystemException {
        SQLExists sql = assocOperator093Range1Query(tGVERIFICARUSUARIOptpatrUsuario, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator093Range1Query (String tGVERIFICARUSUARIOptpatrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGVERIFICARUSUARIOptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator093, Method: assocOperator093Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator097
	@Override
    public Collection<Productos> assocOperator097(String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        try {
            // FOR ALL Productos WHERE (Productos.CodigoLegal = pProducto) DO TGSINC1AGENTEXPRODAUX(Productos, fugetAsesor(ptpAsesor), pCodigo, ptpatrFechaInicio, ptpatrFechaFin)
            return assocOperator097Range1(tGSINC1AGENTEXPRODpProducto);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator097, Method: assocOperator097";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Productos> assocOperator097Range1 (String tGSINC1AGENTEXPRODpProducto) throws SystemException {

        SQLSelect sql = assocOperator097Range1Query(tGSINC1AGENTEXPRODpProducto);
        return new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute();
    }


    public SQLPopulation assocOperator097Range1Query (String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", ProductosConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.CodigoLegal = pProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODpProducto, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator097, Method: assocOperator097Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator098
	@Override
    public Boolean assocOperator098(String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        try {
            // EXIST (Productos) WHERE (Productos.CodigoLegal = pProducto)
            return assocOperator098Range1(tGSINC1AGENTEXPRODpProducto);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator098, Method: assocOperator098";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator098Range1 (String tGSINC1AGENTEXPRODpProducto) throws SystemException {
        SQLExists sql = assocOperator098Range1Query(tGSINC1AGENTEXPRODpProducto, null);
        return !new TypedQueryBuilder<Productos>(em, Productos.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator098Range1Query (String tGSINC1AGENTEXPRODpProducto, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", ProductosConstants.CLASS_NAME, ProductosConstants.CLASS_NAME, null, ProductosConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Productos.CodigoLegal = pProducto
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(ProductosConstants.CLASS_NAME + "." + ProductosConstants.ATTR_NAME_PRODUCTOSCODIGOLEGAL, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODpProducto, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator098, Method: assocOperator098Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator100
	@Override
    public Collection<AgentexProducto> assocOperator100(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        try {
            // FOR ALL AgentexProducto WHERE (AgentexProducto.Asesor = ptpagrAsesor AND AgentexProducto.Codigo = ptpatrCodigo) DO AgentexProducto.TSINCRONIZAR(AgentexProducto, ptpatrFechaInicio, ptpatrFechaFin, ptpagrProducto)
            return assocOperator100Range1(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator100, Method: assocOperator100";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<AgentexProducto> assocOperator100Range1 (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {

        SQLSelect sql = assocOperator100Range1Query(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo);
        return new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute();
    }


    public SQLPopulation assocOperator100Range1Query (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AgentexProductoConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = ptpagrAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(AgentexProductoConstants.CLASS_NAME + "." + AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, tGSINC1AGENTEXPRODAUXptpagrAsesor.getOid(), GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AgentexProducto.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.CLASS_NAME + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOCODIGO, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODAUXptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator100, Method: assocOperator100Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator101
	@Override
    public Boolean assocOperator101(Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        try {
            // EXIST (AgentexProducto) WHERE (AgentexProducto.Asesor = ptpagrAsesor AND AgentexProducto.Codigo = ptpatrCodigo)
            return assocOperator101Range1(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator101, Method: assocOperator101";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator101Range1 (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo) throws SystemException {
        SQLExists sql = assocOperator101Range1Query(tGSINC1AGENTEXPRODAUXptpagrAsesor, tGSINC1AGENTEXPRODAUXptpatrCodigo, null);
        return !new TypedQueryBuilder<AgentexProducto>(em, AgentexProducto.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator101Range1Query (Asesor tGSINC1AGENTEXPRODAUXptpagrAsesor, Long tGSINC1AGENTEXPRODAUXptpatrCodigo, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, null, AgentexProductoConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", AgentexProductoConstants.CLASS_NAME, AgentexProductoConstants.CLASS_NAME, null, AgentexProductoConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // AgentexProducto.Asesor = ptpagrAsesor
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathInstance operand112 = new SQLWhereOperandPathInstance(AgentexProductoConstants.CLASS_NAME + "." + AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME);
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandOVParameter operand223 = new SQLWhereOperandOVParameter(GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR, AsesorConstants.CLASS_NAME, AsesorConstants.CLASS_NAME, tGSINC1AGENTEXPRODAUXptpagrAsesor.getOid(), GlobalServiceConstants.GS_ARG_NAME_TGSINC1AGENTEXPRODAUX_TGSINC1AGENTEXPRODAUXPTPAGRASESOR);
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);


            // AgentexProducto.Codigo = ptpatrCodigo
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(AgentexProductoConstants.CLASS_NAME + "." + AgentexProductoConstants.ATTR_NAME_AGENTEXPRODUCTOCODIGO, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(tGSINC1AGENTEXPRODAUXptpatrCodigo, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator101, Method: assocOperator101Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator116
	@Override
    public Collection<Asesor> assocOperator116(String tGPOSPROCESS1ASESORpUsuario) throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.Usuario = pUsuario) DO Asesor.TPOSPROCESOSINC(Asesor, pEsDirector)
            return assocOperator116Range1(tGPOSPROCESS1ASESORpUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator116, Method: assocOperator116";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Asesor> assocOperator116Range1 (String tGPOSPROCESS1ASESORpUsuario) throws SystemException {

        SQLSelect sql = assocOperator116Range1Query(tGPOSPROCESS1ASESORpUsuario);
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator116Range1Query (String tGPOSPROCESS1ASESORpUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.Usuario = pUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGPOSPROCESS1ASESORpUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator116, Method: assocOperator116Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator117
	@Override
    public Collection<Asesor> assocOperator117() throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.esDirector = false AND EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = true) DO Asesor.TPOSPROCESOSINC(Asesor, true)
            return assocOperator117Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator117, Method: assocOperator117";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Asesor> assocOperator117Range1 () throws SystemException {

        SQLSelect sql = assocOperator117Range1Query();
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator117Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.esDirector = false
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + AsesorConstants.ATTR_NAME_ASESORESDIRECTOR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = true
                // 'exist' Association operator
                SQLWhereOperandSubQuery operandSubQueryAssocOperator118 = new SQLWhereOperandSubQuery(assocOperator118Range1Query(sql));
                conjunction.addOperand(operandSubQueryAssocOperator118);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator117, Method: assocOperator117Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator118
	@Override
    public Boolean assocOperator118() throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario)
            return assocOperator118Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator118, Method: assocOperator118";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator118Range1 () throws SystemException {
        SQLExists sql = assocOperator118Range1Query(null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator118Range1Query (SQLSelect superQuery) throws SystemException {
        try {
            // Path starts with a class in the subquery
            SQLExists sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.CodJefe = Asesor.Usuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOCODJEFE, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    SQLWhereOperandPathAttribute operand223 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setSecondOperand(operand223);
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator118, Method: assocOperator118Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator119
	@Override
    public Collection<Asesor> assocOperator119() throws SystemException {
        try {
            // FOR ALL Asesor WHERE (Asesor.esDirector = true AND EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = false) DO Asesor.TPOSPROCESOSINC(Asesor, false)
            return assocOperator119Range1();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator119, Method: assocOperator119";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Asesor> assocOperator119Range1 () throws SystemException {

        SQLSelect sql = assocOperator119Range1Query();
        return new TypedQueryBuilder<Asesor>(em, Asesor.class).build(sql).execute();
    }


    public SQLPopulation assocOperator119Range1Query () throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", AsesorConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Asesor.esDirector = true
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(AsesorConstants.CLASS_NAME + "." + AsesorConstants.ATTR_NAME_ASESORESDIRECTOR, Constants.Type.BOOL.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(Boolean.TRUE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison1);


            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario) = false
                {
                    // 'not' Logical operator
                    SQLWhereNegation comparison2 = new SQLWhereNegation(sql);
                
                    // Operand 1
                    // 'exist' Association operator
                    SQLWhereOperandSubQuery operandSubQueryAssocOperator120 = new SQLWhereOperandSubQuery(assocOperator118Range1Query(sql));
                    comparison2.addOperand(operandSubQueryAssocOperator120);
                    
                    conjunction.addOperand(comparison2);
                }

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator119, Method: assocOperator119Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator120
	@Override
    public Boolean assocOperator120() throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.CodJefe = Asesor.Usuario)
            return assocOperator118();
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator120, Method: assocOperator120";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator121
	@Override
    public Boolean assocOperator121(String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException {
        try {
            // EXIST (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP)
            return assocOperator121Range1(tCREARAGENTEptpatrUsuarioLDAP);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator121, Method: assocOperator121";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Boolean assocOperator121Range1 (String tCREARAGENTEptpatrUsuarioLDAP) throws SystemException {
        SQLExists sql = assocOperator121Range1Query(tCREARAGENTEptpatrUsuarioLDAP, null);
        return !new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().isEmpty();
    }


    public SQLExists assocOperator121Range1Query (String tCREARAGENTEptpatrUsuarioLDAP, SQLSelect superQuery) throws SystemException {
        try {
            SQLExists sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLExists(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLExists("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tCREARAGENTEptpatrUsuarioLDAP!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tCREARAGENTEptpatrUsuarioLDAP, Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator121, Method: assocOperator121Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator122
	@Override
    public Long assocOperator122(String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP AND Funcionario.Id <> pt_p_thisAgente.Id)
            return assocOperator122Range1(tMODIFICARAGENTEptpatrUsuarioLDAP, tMODIFICARAGENTEptpthisAgente);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator122, Method: assocOperator122";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Long assocOperator122Range1 (String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente) throws SystemException {
        SQLCount sql = assocOperator122Range1Query(tMODIFICARAGENTEptpatrUsuarioLDAP, tMODIFICARAGENTEptpthisAgente, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator122Range1Query (String tMODIFICARAGENTEptpatrUsuarioLDAP, Funcionario tMODIFICARAGENTEptpthisAgente, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tMODIFICARAGENTEptpatrUsuarioLDAP!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tMODIFICARAGENTEptpatrUsuarioLDAP, Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);


            // Funcionario.Id <> pt_p_thisAgente.Id
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOID, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(tMODIFICARAGENTEptpthisAgente.getFuncionarioId(), Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator122, Method: assocOperator122Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator129
	@Override
    public Collection<Funcionario> assocOperator129(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        try {
            // FOR ALL Funcionario WHERE (Funcionario.Usuario = ptpatrUsuario AND Funcionario.Manual = false) DO Funcionario.modAsesorAgencia(oaFuncionario, ptpatrUsuario, Funcionario.CodJefe)
            return assocOperator129Range1(tGNEWASESORAGENCIAptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator129, Method: assocOperator129";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Funcionario> assocOperator129Range1 (String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {

        SQLSelect sql = assocOperator129Range1Query(tGNEWASESORAGENCIAptpatrUsuario);
        return new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute();
    }


    public SQLPopulation assocOperator129Range1Query (String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = ptpatrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGNEWASESORAGENCIAptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator129, Method: assocOperator129Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator130
	@Override
    public Long assocOperator130(String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP)
            return assocOperator130Range1(tGNEWASESORAGENCIAptpatrUsuarioLDAP);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator130, Method: assocOperator130";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Long assocOperator130Range1 (String tGNEWASESORAGENCIAptpatrUsuarioLDAP) throws SystemException {
        SQLCount sql = assocOperator130Range1Query(tGNEWASESORAGENCIAptpatrUsuarioLDAP, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator130Range1Query (String tGNEWASESORAGENCIAptpatrUsuarioLDAP, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_p_atrUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tGNEWASESORAGENCIAptpatrUsuarioLDAP!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGNEWASESORAGENCIAptpatrUsuarioLDAP, Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator130, Method: assocOperator130Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator131
	@Override
    public Long assocOperator131(String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.Usuario = pt_p_atrUsuario AND Funcionario.Manual = false)
            return assocOperator131Range1(tGNEWASESORAGENCIAptpatrUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator131, Method: assocOperator131";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Long assocOperator131Range1 (String tGNEWASESORAGENCIAptpatrUsuario) throws SystemException {
        SQLCount sql = assocOperator131Range1Query(tGNEWASESORAGENCIAptpatrUsuario, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator131Range1Query (String tGNEWASESORAGENCIAptpatrUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = pt_p_atrUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGNEWASESORAGENCIAptpatrUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator131, Method: assocOperator131Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator132
	@Override
    public Collection<Funcionario> assocOperator132(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        try {
            // FOR ALL Funcionario WHERE (Funcionario.Usuario = ptpeNumUsuario AND Funcionario.Manual = false) DO Funcionario.modAsesorAgencia(ptpthisAsesor, ptpeNumUsuario, Funcionario.CodJefe)
            return assocOperator132Range1(tGMODASESORAGENCIAptpeNumUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator132, Method: assocOperator132";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<Funcionario> assocOperator132Range1 (String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {

        SQLSelect sql = assocOperator132Range1Query(tGMODASESORAGENCIAptpeNumUsuario);
        return new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute();
    }


    public SQLPopulation assocOperator132Range1Query (String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FuncionarioConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = ptpeNumUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGMODASESORAGENCIAptpeNumUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator132, Method: assocOperator132Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator133
	@Override
    public Long assocOperator133(String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.UsuarioLDAP = pt_ptUsuarioLDAP AND Funcionario.Id <> pt_p_thisAsesor.Id)
            return assocOperator133Range1(tGMODASESORAGENCIAptptUsuarioLDAP, tGMODASESORAGENCIAptpthisAsesor);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator133, Method: assocOperator133";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Long assocOperator133Range1 (String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor) throws SystemException {
        SQLCount sql = assocOperator133Range1Query(tGMODASESORAGENCIAptptUsuarioLDAP, tGMODASESORAGENCIAptpthisAsesor, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator133Range1Query (String tGMODASESORAGENCIAptptUsuarioLDAP, Asesor tGMODASESORAGENCIAptpthisAsesor, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.UsuarioLDAP = pt_ptUsuarioLDAP
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIOLDAP, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    if (tGMODASESORAGENCIAptptUsuarioLDAP!= null){
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGMODASESORAGENCIAptptUsuarioLDAP, Constants.Type.STRING.getTypeName()));
                    } else {
                    comparison1.setSecondOperand(new SQLWhereOperandNull());
                    }
                    conjunction.addOperand(comparison1);


            // Funcionario.Id <> pt_p_thisAsesor.Id
                    // '<>' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("<>");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOID, Constants.Type.INT.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(tGMODASESORAGENCIAptpthisAsesor.getFuncionarioId(), Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator133, Method: assocOperator133Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator134
	@Override
    public Long assocOperator134(String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        try {
            // COUNT (Funcionario) WHERE (Funcionario.Usuario = pt_peNumUsuario AND Funcionario.Manual = false)
            return assocOperator134Range1(tGMODASESORAGENCIAptpeNumUsuario);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator134, Method: assocOperator134";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Long assocOperator134Range1 (String tGMODASESORAGENCIAptpeNumUsuario) throws SystemException {
        SQLCount sql = assocOperator134Range1Query(tGMODASESORAGENCIAptpeNumUsuario, null);
        return Long.valueOf(new TypedQueryBuilder<Funcionario>(em, Funcionario.class).build(sql).execute().size());
    }


    public SQLCount assocOperator134Range1Query (String tGMODASESORAGENCIAptpeNumUsuario, SQLSelect superQuery) throws SystemException {
        try {
            SQLCount sql;
            // The path starts with an object
            if (superQuery != null) {
                sql = new SQLCount(superQuery, "", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            } else {
                sql = new SQLCount("", FuncionarioConstants.CLASS_NAME, FuncionarioConstants.CLASS_NAME, null, FuncionarioConstants.CLASS_NAME);
            }
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // Funcionario.Usuario = pt_peNumUsuario
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOUSUARIO, Constants.Type.STRING.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGMODASESORAGENCIAptpeNumUsuario, Constants.Type.STRING.getTypeName()));
                    conjunction.addOperand(comparison1);


            // Funcionario.Manual = false
                    // '=' Comparison
                    SQLWhereComparison comparison2 = new SQLWhereComparison(sql);
                    comparison2.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand113 = new SQLWhereOperandPathAttribute(FuncionarioConstants.CLASS_NAME + "." + FuncionarioConstants.ATTR_NAME_FUNCIONARIOMANUAL, Constants.Type.BOOL.getTypeName());
                    comparison2.setFirstOperand(operand113);
                    
                    // Operand 2
                    comparison2.setSecondOperand(new SQLWhereOperandLiteral(Boolean.FALSE, Constants.Type.BOOL.getTypeName()));
                    conjunction.addOperand(comparison2);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator134, Method: assocOperator134Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    // AssocOperator: AssocOperator159
	@Override
    public Collection<FrecuenciaAct> assocOperator159(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = ptNumParametrica) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), ptResultado, AGENTFuncionario.Usuario, AGENTFuncionario.drvNombreCompleto)
            return assocOperator159Range1(tGFIJARDATOSSINCptNumParametrica);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator159, Method: assocOperator159";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }



    public Collection<FrecuenciaAct> assocOperator159Range1 (Long tGFIJARDATOSSINCptNumParametrica) throws SystemException {

        SQLSelect sql = assocOperator159Range1Query(tGFIJARDATOSSINCptNumParametrica);
        return new TypedQueryBuilder<FrecuenciaAct>(em, FrecuenciaAct.class).build(sql).execute();
    }


    public SQLPopulation assocOperator159Range1Query (Long tGFIJARDATOSSINCptNumParametrica) throws SystemException {
        try {
            SQLPopulation sql = new SQLPopulation("", FrecuenciaActConstants.CLASS_NAME);
            SQLWhereConjunction conjunction = new SQLWhereConjunction();

            // FrecuenciaAct.Parametrica = ptNumParametrica
                    // '=' Comparison
                    SQLWhereComparison comparison1 = new SQLWhereComparison(sql);
                    comparison1.setOperator("=");
                    
                    // Operand 1
                    SQLWhereOperandPathAttribute operand112 = new SQLWhereOperandPathAttribute(FrecuenciaActConstants.CLASS_NAME + "." + FrecuenciaActConstants.ATTR_NAME_FRECUENCIAACTPARAMETRICA, Constants.Type.NAT.getTypeName());
                    comparison1.setFirstOperand(operand112);
                    
                    // Operand 2
                    comparison1.setSecondOperand(new SQLWhereOperandLiteral(tGFIJARDATOSSINCptNumParametrica, Constants.Type.INT.getTypeName()));
                    conjunction.addOperand(comparison1);

            sql.addOperand(conjunction);
            return sql;
        } catch (Exception e) {
            String exceptionMessage = "Assoc.Operator: AssocOperator159, Method: assocOperator159Range1Query";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator160
	@Override
    public Collection<FrecuenciaAct> assocOperator160(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = ptNumParametrica) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), ptResultado, AGENTUsuarioSistemaExterno.Login, "")
            return assocOperator159(tGFIJARDATOSSINCptNumParametrica);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator160, Method: assocOperator160";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }
    // AssocOperator: AssocOperator161
	@Override
    public Collection<FrecuenciaAct> assocOperator161(Long tGFIJARDATOSSINCptNumParametrica) throws SystemException {
        try {
            // FOR ALL FrecuenciaAct WHERE (FrecuenciaAct.Parametrica = ptNumParametrica) DO FrecuenciaAct.fijarSincronizacion(FrecuenciaAct, systemDate(), ptResultado, "Auto", "")
            return assocOperator159(tGFIJARDATOSSINCptNumParametrica);
        } catch (Exception e) {
            String exceptionMessage = "Definition Class: GLOBAL, Assoc.Operator: AssocOperator161, Method: assocOperator161";
            org.slf4j.LoggerFactory.getLogger(this.getClass()).error(exceptionMessage);
            throw new SystemException(e, exceptionMessage);
        }
    }

    @Override
    public void refreshEntity(Object object) {
        super.refreshEntity(object);
    }
}
