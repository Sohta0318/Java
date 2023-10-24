package dev.lpa.sealed;

public sealed abstract class SpecialAbstractClass permits SpecialAbstractClass.Kid, SealedKid, FinalKid, NonSealedKid {
    final class Kid extends SpecialAbstractClass{

    }
}
