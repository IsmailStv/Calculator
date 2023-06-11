package PostServise;

import java.util.logging.Level;
import java.util.logging.Logger;

class Main {

    public static final String AUSTIN_POWERS = "Austin Powers";
    public static final String WEAPONS = "weapons";
    public static final String BANNED_SUBSTANCE = "banned substance";

    //Stepik code: start

    //Тут Писать свой КОД

    //Stepik code: end

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        Inspector inspector = new Inspector();
        Spy spy = new Spy(logger);
        Thief thief = new Thief(10000);
        UntrustworthyMailWorker worker = new UntrustworthyMailWorker(new MailService[]{spy, thief, inspector});
        AbstractSendable[] correspondence = {
                new MailMessage("Oxxxymiron", "Гнойный", " Я здесь чисто по фану, поглумиться над слабым\n" +
                        "Ты же вылез из мамы под мой дисс на Бабана...."),
                new MailMessage("Гнойный", "Oxxxymiron", "....Что? Так болел за Россию, что на нервах терял ганглии.\n" +
                        "Но когда тут проходили митинги, где ты сидел? В Англии!...."),
                new MailMessage("Жириновский", AUSTIN_POWERS, "Бери пацанов, и несите меня к воде."),
                new MailMessage(AUSTIN_POWERS, "Пацаны", "Го, потаскаем Вольфовича как Клеопатру"),
                new MailPackage("берег", "море", new Package("ВВЖ", 32)),
                new MailMessage("NASA", AUSTIN_POWERS, "Найди в России ракетные двигатели и лунные stones"),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("ракетный двигатель ", 2500000)),
                new MailPackage(AUSTIN_POWERS, "NASA", new Package("stones ", 1000)),
                new MailPackage("Китай", "КНДР", new Package("banned substance ", 10000)),
                new MailPackage(AUSTIN_POWERS, "Жопа запрещенная группировка", new Package("tiny bomb", 9000)),
                new MailMessage(AUSTIN_POWERS, "Психиатр", "Помогите"),
        };

        for (AbstractSendable p : correspondence) {
            try {
                print("До:  ", p);
                Sendable sendable = worker.processMail(p);
                print("После:  ", sendable);
            } catch (StolenPackageException | IllegalPackageException e) {
                logger.log(Level.WARNING, "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                        + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                        + " Цена=" + ((MailPackage) p).getContent().getPrice()) + " Exceptions: " + e);
            }
        }
    }

    public static void print(String prefix, Sendable p) {
        System.out.println(prefix + "из: " + p.getFrom() + " куда: " + p.getTo() + " Содержимое: "
                + (p instanceof MailMessage ? ((MailMessage) p).getMessage() : ((MailPackage) p).getContent().getContent()
                + " Цена=" + ((MailPackage) p).getContent().getPrice()));
    }

    /*
        Интерфейс: сущность, которую можно отправить по почте.
        У такой сущности можно получить от кого и кому направляется письмо.
    */
    public static interface Sendable {
        String getFrom();

        String getTo();
    }

    /*
       Абстрактный класс,который позволяет абстрагировать логику хранения
       источника и получателя письма в соответствующих полях класса.
    */
    public static abstract class AbstractSendable implements Sendable {
        protected final String from;
        protected final String to;

        public AbstractSendable(String from, String to) {
            this.from = from;
            this.to = to;
        }

        @Override
        public String getFrom() {
            return from;
        }

        @Override
        public String getTo() {
            return to;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            AbstractSendable that = (AbstractSendable) o;
            if (!from.equals(that.from)) return false;
            if (!to.equals(that.to)) return false;
            return true;
        }
    }

    /*
    Письмо, у которого есть текст, который можно получить с помощью метода `getMessage`
    */
    public static class MailMessage extends AbstractSendable {
        private final String message;

        public MailMessage(String from, String to, String message) {
            super(from, to);
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailMessage that = (MailMessage) o;
            if (message != null ? !message.equals(that.message) : that.message != null) return false;
            return true;
        }
    }

    /*
    Посылка, содержимое которой можно получить с помощью метода `getContent`
    */
    public static class MailPackage extends AbstractSendable {
        private final Package content;

        public MailPackage(String from, String to, Package content) {
            super(from, to);
            this.content = content;
        }

        public Package getContent() {
            return content;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            MailPackage that = (MailPackage) o;
            if (!content.equals(that.content)) return false;
            return true;
        }
    }

    /*
    Класс, который задает посылку. У посылки есть текстовое описание содержимого и целочисленная ценность.
    */
    public static class Package {
        private final String content;
        private final int price;

        public Package(String content, int price) {
            this.content = content;
            this.price = price;
        }

        public String getContent() {
            return content;
        }

        public int getPrice() {
            return price;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (price != aPackage.price) return false;
            if (!content.equals(aPackage.content)) return false;

            return true;
        }
    }

    /*
    Интерфейс, который задает класс, который может каким-либо образом обработать почтовый объект.
    */
    public static interface MailService {
        Sendable processMail(Sendable mail);
    }

    /*
    Класс, в котором скрыта логика настоящей почты
    */
    public static class RealMailService implements MailService {

        @Override
        public Sendable processMail(Sendable mail) {
            // Здесь описан код настоящей системы отправки почты.
            return mail;
        }
    }


// implement UntrustworthyMailWorker, Spy, Inspector, Thief, StolenPackageException, IllegalPackageException as public static classes here

    /**
     * UntrustworthyMailWorker – класс, моделирующий ненадежного работника почты, который вместо того,
     * чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
     * набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.
     * У UntrustworthyMailWorker должен быть конструктор от массива MailService ( результат вызова processMail первого элемента
     * массива передается на вход processMail второго элемента, и т. д.) и метод getRealMailService, который возвращает ссылку
     * на внутренний экземпляр RealMailService.
     */


    public static class UntrustworthyMailWorker implements MailService {
        private RealMailService rms;  /* внутренний экземпляр RealMailService*/
        private MailService[] mailserv; //набор третьих лиц

        //   У UntrustworthyMailWorker должен быть конструктор от массива MailService
        public UntrustworthyMailWorker(MailService[] mailserv) {
            this.mailserv = mailserv;
            this.rms = new RealMailService();
        }

        /* моделирующий ненадежного работника почты, который вместо того,
         *  чтобы передать почтовый объект непосредственно в сервис почты, последовательно передает этот объект
         *  набору третьих лиц, а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService.*/
        public Sendable processMail(Sendable mail) {
            for (int i = 0; i < mailserv.length; i++) { /*перебор набора третьих лиц*/
                mail = mailserv[i].processMail(mail); /*результат вызова processMail первого элемента
                 *  массива передается на вход processMail второго элемента, и т. д. */
            }
            return rms.processMail(mail); /* а затем, в конце концов, передает получившийся объект непосредственно экземпляру RealMailService. */
        }

        public RealMailService getRealMailService() {
            return this.rms;
        } /*  метод getRealMailService, который возвращает ссылку
         *  на внутренний экземпляр RealMailService. */
    }


    /**
     * Spy – шпион, который логгирует о всей почтовой переписке, которая проходит через его руки. Объект конструируется от
     * экземпляра Logger, с помощью которого шпион будет сообщать о всех действиях. Он следит только за объектами класса
     * MailMessage и пишет в логгер следующие сообщения (в выражениях нужно заменить части в фигурных скобках на значения полей почты):
     * 2.1) Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
     * Detected target mail correspondence: from {from} to {to} "{message}"
     * 2.2) Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}
     */
    public static class Spy implements MailService {
        private final Logger logger; /* внутренний логгер, во избежание беды, должен присваиваться один раз*/

        public Spy(final Logger logger) {
            this.logger = logger;
        } /* Объект конструируется от экземпляра Logger, */


        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailMessage) { /* проверяем, что входящая почта  MailMessage, так как  Он следит только за объектами класса
             * MailMessage  / ИЗ условия - Для определения, посылкой или письмом является Sendable объект воспользуйтесь оператором instanceof. */

                MailMessage mail2 = (MailMessage) mail; /*создаем объект (MailMessage) и присваиваем ему пришедший (Sendable) mail*/

                /* Если в качестве отправителя или получателя указан "Austin Powers", то нужно написать в лог сообщение с уровнем WARN:
     Detected target mail correspondence: from {from} to {to} "{message}" */

                /*AUSTIN_POWERS - константа определнная выше в классе.
                 * public static final String AUSTIN_POWERS = "Austin Powers";*/
                if (mail2.getFrom().equals(AUSTIN_POWERS) || mail2.getTo().equals(AUSTIN_POWERS)) {
                    this.logger.log(Level.WARNING, "Detected target mail correspondence: from {0} to {1} \"{2}\"",
                            new Object[]{mail2.getFrom(), mail2.getTo(), mail2.getMessage()});
                }
                /*Иначе, необходимо написать в лог сообщение с уровнем INFO: Usual correspondence: from {from} to {to}*/
                else {
                    logger.log(Level.INFO, "Usual correspondence: from {0} to {1}",
                            new Object[]{mail2.getFrom(), mail2.getTo()});
                }
            }
            return mail; /* метод класса возвращает почту в вызыващий его код*/
        }
    }


    /**
     * Thief – вор, который ворует самые ценные посылки и игнорирует все остальное. Вор принимает в конструкторе переменную int
     * – минимальную стоимость посылки, которую он будет воровать. Также, в данном классе должен присутствовать метод getStolenValue,
     * который возвращает суммарную стоимость всех посылок, которые он своровал. Воровство происходит следующим образом: вместо посылки,
     * которая пришла вору, он отдает новую, такую же, только с нулевой ценностью и содержимым посылки "stones instead of {content}".
     */
    public static class Thief implements MailService {
        private int minStoimost; /* минимальная стоимость посылки, которую он будет воровать.*/
        private int stolenValue; /*Здесь будем хранить сумму украденного */

        public Thief(int minStoimost) { /* Вор принимает в конструкторе переменную int
         * – минимальную стоимость посылки, которую он будет воровать.*/
            this.minStoimost = minStoimost;
            this.stolenValue = 0;   /* При создании Вора сумма украденного будет равна 0*/
        }

        public int getStolenValue() {
            return stolenValue;
        } /*  метод getStolenValue,
         * который возвращает суммарную стоимость всех посылок, которые он своровал. */

        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) { /*Проверяем отправление является ли посылкой*/
                MailPackage mail2 = (MailPackage) mail; /* Слоздаем объект посылка, и присваиваем ему наше отправление*/

                /**Наша посылка состоит из:
                 *   private final Package content;
                 *
                 *
                 *   a Package, в свою очередь, состоит из:
                 *   public static class Package {
                 private final String content;
                 private final int price;
                 *
                 *ПОэтому для того, что бы получить стоимость посылки, надо взять метод getPrice () от
                 * метода getContent () объекта mail2.
                 */
                if (mail2.getContent().getPrice() >= this.minStoimost) { /* Проверяем ценная ли посылка*/
                    this.stolenValue += mail2.getContent().getPrice(); /*Вор прибавляет стоимость воруемой посылки себе*/
                    /* Отдает вместо посылки,которая пришла вору, он отдает новую, такую же, только с нулевой ценностью
                     и содержимым посылки "stones instead of {content}"*/
                    return new MailPackage(mail2.getFrom(), mail2.getTo(),
                            new Package(
                                    "stones instead of " + mail2.getContent().getContent(), 0));
                }
            }
            return mail; /*Вор отдает послыки с неценными посылками и письмами, без изменений*/
        }
    }


    /**
     * Inspector – Инспектор, который следит за запрещенными и украденными посылками и бьет тревогу в виде исключения,
     * если была обнаружена подобная посылка. Если он заметил запрещенную посылку с одним из запрещенных содержимым
     * "weapons" и "banned substance"), то он бросает IllegalPackageException. Если он находит посылку, состоящую из
     * камней (содержит слово "stones"), то тревога прозвучит в виде StolenPackageException. Оба исключения вы должны
     * объявить самостоятельно в виде непроверяемых исключений.
     */
    public static class Inspector implements MailService {
        public Sendable processMail(Sendable mail) {
            if (mail instanceof MailPackage) { /*Проверка посылка ли пришла?*/
                MailPackage mail2 = (MailPackage) mail;

                /*Если он заметил запрещенную посылку с одним из запрещенных содержимым
                 *  "weapons" и "banned substance"), то он бросает IllegalPackageException.*/
                if (mail2.getContent().getContent().contains(WEAPONS) ||
                        mail2.getContent().getContent().contains(BANNED_SUBSTANCE)) {
                    throw new IllegalPackageException();
                }
                /*Если он находит посылку, состоящую из камней (содержит слово "stones"),
                то тревога прозвучит в виде StolenPackageException.*/
                if (mail2.getContent().getContent().contains("stones"))
                    throw new StolenPackageException();
                return mail2;
            }
            return mail;
        }
    }


    /*Оба исключения вы должны
     *  объявить самостоятельно в виде непроверяемых исключений.  */
    public static class StolenPackageException extends RuntimeException {
        public StolenPackageException() {
            super("Discovered the theft from the parcel!");
        }
    }

    public static class IllegalPackageException extends RuntimeException {
        public IllegalPackageException() {
            super("IllegalPackageException!");
        }
    }
}