import { IonCard, IonCardHeader, IonCardTitle, IonCardSubtitle, IonButton, IonCardContent } from "@ionic/react";
import { ItemEnchereProps } from "../util/Interface";
import "../theme/enchere.css";

export const ItemEnchere: React.FC<ItemEnchereProps> = ({ enchere }) => {

    const url = "/updateEnchere?id=" + enchere["id"];

    return (
        <IonCard className="box">
            <IonCardHeader>
                <IonCardTitle>{enchere["nomProduit"]}</IonCardTitle>
                <IonCardSubtitle>{enchere["dateDebut"]} </IonCardSubtitle>
            </IonCardHeader>
            <IonCardContent>
                <h2>{enchere["prixmin"]} Ar</h2>
            </IonCardContent>
            <IonButton fill="clear" href={url}>Voir details</IonButton>
        </IonCard>
    );
}