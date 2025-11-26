Q: Does overriding a method replace the original method call even if the reference is of parent type?

A: Yes — overridden instance methods use the object type at runtime (dynamic dispatch). Static methods use the reference type (they are hidden, not overridden).

If parent needs arguments, children must provide them explicitly.

Classes that don’t override equals() are doing reference comparison. StringBuilder is a famous example


**Projected Access across packages**

Same package: accessible anywhere
Different package: only accessible from subclass, and only via subclass reference (not parent reference)


**Access modifiers rules**
Accessibility levels (most to least restrictive)
private -> default -> protected -> public

Remember “OVERRIDE = UPGRADE” - you can make methods more accessible, 
return more specific types, and throw fewer/more specific exceptions, but never the reverse.

Q: Can an overriding method throw a broader checked exception than the parent method?

A: No — overriding methods can only throw the same, fewer, or more specific checked exceptions. 
Broader exceptions would violate the substitution principle.


Learning Tip: Think “ABSTRACT = BLUEPRINT” - defines the structure but leaves implementation details to subclasses. Like architectural blueprints, you can’t build from them directly but they guide construction.

Q: Can an abstract class have a constructor?
A: Yes — abstract classes can have constructors that are called when concrete subclasses are instantiated via super().


Q: What happens if a class implements two interfaces with conflicting default methods?
A: Compile error — the class must override the conflicting method to explicitly resolve which implementation to use or provide its own.