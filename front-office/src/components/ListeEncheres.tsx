import { IonList } from "@ionic/react";
import "../css/styles.css";
import { ItemEnchere } from "./ItemEnchere";
import { ListeEncheresProps } from "../util/Interface";

export const ListeEncheres: React.FC<ListeEncheresProps> = ({ encheres }) => {

    return (
        <>
            <IonList className="flex-container">
                {encheres.map((enchere: any) => {
                    return (
                        <ItemEnchere enchere={enchere} />
                    );
                })}
            </IonList>
        </>
    );
}