package MetaModel.constraints;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.base.BaseConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.ConstraintFunction;
import jetbrains.mps.smodel.runtime.ConstraintContext_CanBeChild;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import jetbrains.mps.smodel.runtime.CheckingNodeContext;
import jetbrains.mps.smodel.runtime.base.BasePropertyConstraintsDescriptor;
import jetbrains.mps.smodel.runtime.ConstraintsDescriptor;
import jetbrains.mps.smodel.SNodePointer;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SPropertyOperations;
import org.jetbrains.mps.openapi.language.SEnumerationLiteral;
import java.util.Map;
import org.jetbrains.mps.openapi.language.SProperty;
import jetbrains.mps.smodel.runtime.PropertyConstraintsDescriptor;
import java.util.HashMap;
import org.jetbrains.mps.openapi.language.SAbstractConcept;
import org.jetbrains.mps.openapi.language.SContainmentLink;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import org.jetbrains.mps.openapi.language.SConcept;
import jetbrains.mps.smodel.adapter.structure.MetaAdapterFactory;

public class AttributeConnector_Constraints extends BaseConstraintsDescriptor {
  public AttributeConnector_Constraints() {
    super(CONCEPTS.AttributeConnector$oc);
  }

  @Override
  protected ConstraintFunction<ConstraintContext_CanBeChild, Boolean> calculateCanBeChildConstraint() {
    return new ConstraintFunction<ConstraintContext_CanBeChild, Boolean>() {
      @NotNull
      public Boolean invoke(@NotNull ConstraintContext_CanBeChild context, @Nullable CheckingNodeContext checkingNodeContext) {
        boolean result = staticCanBeAChild(context.getNode(), context.getParentNode(), context.getConcept(), context.getLink());

        if (!(result) && checkingNodeContext != null) {
          checkingNodeContext.setBreakingNode(canBeChildBreakingPoint);
        }

        return result;
      }
    };
  }
  public static class Constraint_Property extends BasePropertyConstraintsDescriptor {
    public Constraint_Property(ConstraintsDescriptor container) {
      super(PROPS.constraint$DHG8, container);
    }
    @Override
    public boolean hasOwnValidator() {
      return true;
    }
    private static final SNodePointer validatePropertyBreakingPoint = new SNodePointer("r:489510dc-ea52-4795-b022-2cffd05211ac(MetaModel.constraints)", "4479962183591598386");
    @Override
    public boolean validateValue(SNode node, Object propertyValue, CheckingNodeContext checkingNodeContext) {
      boolean result = staticValidateProperty(node, SPropertyOperations.castEnummember(propertyValue));
      if (!(result) && checkingNodeContext != null) {
        checkingNodeContext.setBreakingNode(validatePropertyBreakingPoint);
      }
      return result;
    }
    private static boolean staticValidateProperty(SNode node, SEnumerationLiteral propertyValue) {
      return propertyValue.getName().equals("PartialMap") || propertyValue.getName().equals("TotalMap");
    }
  }
  @Override
  protected Map<SProperty, PropertyConstraintsDescriptor> getSpecifiedProperties() {
    Map<SProperty, PropertyConstraintsDescriptor> properties = new HashMap<SProperty, PropertyConstraintsDescriptor>();
    properties.put(PROPS.constraint$DHG8, new Constraint_Property(this));
    return properties;
  }
  private static boolean staticCanBeAChild(SNode node, SNode parentNode, SAbstractConcept childConcept, SContainmentLink link) {
    return SNodeOperations.isInstanceOf(parentNode, CONCEPTS.Class$_H);
    //  May only occur as child of a class and not as a target in an association   

  }
  private static final SNodePointer canBeChildBreakingPoint = new SNodePointer("r:489510dc-ea52-4795-b022-2cffd05211ac(MetaModel.constraints)", "1316074037364894814");

  private static final class CONCEPTS {
    /*package*/ static final SConcept AttributeConnector$oc = MetaAdapterFactory.getConcept(0x9859e7a148764909L, 0xa6648a214c206698L, 0x5b448949fec5dbfeL, "MetaModel.structure.AttributeConnector");
    /*package*/ static final SConcept Class$_H = MetaAdapterFactory.getConcept(0x9859e7a148764909L, 0xa6648a214c206698L, 0x355f4a6bd0ef9b2dL, "MetaModel.structure.Class");
  }

  private static final class PROPS {
    /*package*/ static final SProperty constraint$DHG8 = MetaAdapterFactory.getProperty(0x9859e7a148764909L, 0xa6648a214c206698L, 0x12a1d358b101f296L, 0x12a1d358b101f2a5L, "constraint");
  }
}
