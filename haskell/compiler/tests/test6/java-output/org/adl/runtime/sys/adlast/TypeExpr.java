/* @generated from adl module sys.adlast */

package org.adl.runtime.sys.adlast;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.adl.runtime.Builders;
import org.adl.runtime.Factories;
import org.adl.runtime.Factory;
import org.adl.runtime.JsonBinding;
import org.adl.runtime.JsonBindings;
import org.adl.runtime.Lazy;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TypeExpr {

  /* Members */

  private TypeRef typeRef;
  private List<TypeExpr> parameters;

  /* Constructors */

  public TypeExpr(TypeRef typeRef, List<TypeExpr> parameters) {
    this.typeRef = Objects.requireNonNull(typeRef);
    this.parameters = Objects.requireNonNull(parameters);
  }

  public TypeExpr(TypeExpr other) {
    this.typeRef = TypeRef.FACTORY.create(other.typeRef);
    this.parameters = Factories.list(TypeExpr.FACTORY).create(other.parameters);
  }

  /* Accessors and mutators */

  public TypeRef getTypeRef() {
    return typeRef;
  }

  public TypeExpr setTypeRef(TypeRef typeRef) {
    this.typeRef = Objects.requireNonNull(typeRef);
    return this;
  }

  public List<TypeExpr> getParameters() {
    return parameters;
  }

  public TypeExpr setParameters(List<TypeExpr> parameters) {
    this.parameters = Objects.requireNonNull(parameters);
    return this;
  }

  /* Object level helpers */

  @Override
  public boolean equals(Object other0) {
    if (!(other0 instanceof TypeExpr)) {
      return false;
    }
    TypeExpr other = (TypeExpr) other0;
    return
      typeRef.equals(other.typeRef) &&
      parameters.equals(other.parameters);
  }

  @Override
  public int hashCode() {
    int _result = 1;
    _result = _result * 37 + typeRef.hashCode();
    _result = _result * 37 + parameters.hashCode();
    return _result;
  }

  /* Builder */

  public static class Builder {
    private TypeRef typeRef;
    private List<TypeExpr> parameters;

    public Builder() {
      this.typeRef = null;
      this.parameters = null;
    }

    public Builder setTypeRef(TypeRef typeRef) {
      this.typeRef = Objects.requireNonNull(typeRef);
      return this;
    }

    public Builder setParameters(List<TypeExpr> parameters) {
      this.parameters = Objects.requireNonNull(parameters);
      return this;
    }

    public TypeExpr create() {
      Builders.checkFieldInitialized("TypeExpr", "typeRef", typeRef);
      Builders.checkFieldInitialized("TypeExpr", "parameters", parameters);
      return new TypeExpr(typeRef, parameters);
    }
  }

  /* Factory for construction of generic values */

  public static final Factory<TypeExpr> FACTORY = new Factory<TypeExpr>() {
    @Override
    public TypeExpr create(TypeExpr other) {
      return new TypeExpr(other);
    }

    @Override
    public TypeExpr typeExpr() {
      ScopedName scopedName = new ScopedName("sys.adlast", "TypeExpr");
      ArrayList<TypeExpr> params = new ArrayList<>();
      return new TypeExpr(TypeRef.reference(scopedName), params);
    }
    @Override
    public JsonBinding<TypeExpr> jsonBinding() {
      return TypeExpr.jsonBinding();
    }
  };

  /* Json serialization */

  public static JsonBinding<TypeExpr> jsonBinding() {
    final Lazy<JsonBinding<TypeRef>> typeRef = new Lazy<>(() -> TypeRef.jsonBinding());
    final Lazy<JsonBinding<List<TypeExpr>>> parameters = new Lazy<>(() -> JsonBindings.list(TypeExpr.jsonBinding()));
    final Factory<TypeExpr> _factory = FACTORY;

    return new JsonBinding<TypeExpr>() {
      @Override
      public Factory<TypeExpr> factory() {
        return _factory;
      }

      @Override
      public JsonElement toJson(TypeExpr _value) {
        JsonObject _result = new JsonObject();
        _result.add("typeRef", typeRef.get().toJson(_value.typeRef));
        _result.add("parameters", parameters.get().toJson(_value.parameters));
        return _result;
      }

      @Override
      public TypeExpr fromJson(JsonElement _json) {
        JsonObject _obj = JsonBindings.objectFromJson(_json);
        return new TypeExpr(
          JsonBindings.fieldFromJson(_obj, "typeRef", typeRef.get()),
          JsonBindings.fieldFromJson(_obj, "parameters", parameters.get())
        );
      }
    };
  }
}
